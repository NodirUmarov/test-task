package kz.redmadrobot.testtask.business.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import kz.redmadrobot.testtask.business.exception.AdNotFoundException;
import kz.redmadrobot.testtask.business.exception.CategoryNotFoundException;
import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.dto.AdMapper;
import kz.redmadrobot.testtask.business.mapper.request.CreateAdRequestMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.enums.AdFilterDetails;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;
import kz.redmadrobot.testtask.business.service.AdService;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import kz.redmadrobot.testtask.dao.entity.enums.AdStatus;
import kz.redmadrobot.testtask.dao.entity.user.User;
import kz.redmadrobot.testtask.dao.repository.AdRepository;
import kz.redmadrobot.testtask.dao.repository.CategoryRepository;
import kz.redmadrobot.testtask.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;
    private final CreateAdRequestMapper adRequestMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public AdDto create(CreateAdRequest request) {
        log.info("Creating ad with title='{}'", request.getTitle());

        Ad ad = adRequestMapper.toEntity(request);
        ad.setAdStatus(AdStatus.ACTIVE);

        log.info("Searching for ads category by id={}", request.getCategoryId());
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        log.info("Searching for user by id={}", request.getUserId());
        User user = userRepository.findById(request.getUserId()).orElseThrow(UserNotFoundException::new);

        ad.setCategory(category);
        ad.setCreatedBy(user);
        ad.setCreatedDate(LocalDateTime.now());
        ad.setLastModifiedDate(LocalDateTime.now());
        adRepository.save(ad);

        log.info("Ad created and id={} assigned", ad.getId());
        return adMapper.toDto(ad);
    }

    @Override
    public AdDto getOne(Long id) {
        Ad ad = adRepository.findById(id).map(res -> {
            if (res.getUntil().isBefore(LocalDateTime.now())) {
                res.setAdStatus(AdStatus.WITHDRAWN);
            }
            return adRepository.save(res);
        }).orElseThrow(AdNotFoundException::new);

        return adMapper.toDto(ad);
    }

    @Override
    public List<AdDto> getAll(Long from, Long to) {
        log.info("Retrieving all ads from db...");

        Pageable pageable = PageRequest.of(from.intValue(), to.intValue());
        Page<Ad> adDtoPage = adRepository.findAll(pageable);

        List<AdDto> adDtos = adMapper.toDtoList(adDtoPage.toList());
        log.info("{} ads retrieved from db", adDtos.size());
        return adDtos;
    }

    @Override
    public List<AdDto> getAllContainingWord(Long from, Long to, String content, AdFilterDetails adFilterDetails) {
        log.info("Retrieving all ads from db, {} containing value '{}'...", adFilterDetails.name().toLowerCase(), content);

        LocalDateTime now = LocalDateTime.now();
        Pageable pageable = PageRequest.of(from.intValue(), to.intValue());
        Page<Ad> adDtoPage = switch (adFilterDetails) {
            case TITLE -> adRepository.findAllByTitleContainingAndUntilAfterOrUntilIsNull(pageable, content, now);
            case DESCRIPTION -> adRepository.findAllByDescriptionContainingAndUntilAfterOrUntilIsNull(pageable, content, now);
            case ALL -> adRepository.findAllByTitleOrDescriptionContainingAndUntilAfterOrUntilIsNull(pageable, content, content, now);
        };


        List<AdDto> adDtos = adMapper.toDtoList(adDtoPage.toList());
        log.info("{} ads retrieved from db", adDtos.size());
        return adDtos;
    }
}
