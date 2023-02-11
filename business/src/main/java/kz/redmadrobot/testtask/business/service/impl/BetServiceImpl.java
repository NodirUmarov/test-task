package kz.redmadrobot.testtask.business.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import kz.redmadrobot.testtask.business.exception.AdIsWithdrawnException;
import kz.redmadrobot.testtask.business.exception.AdNotFoundException;
import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.CreateBetMapper;
import kz.redmadrobot.testtask.business.mapper.dto.BetMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.business.model.request.CreateBetRequest;
import kz.redmadrobot.testtask.business.service.BetService;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import kz.redmadrobot.testtask.dao.entity.user.User;
import kz.redmadrobot.testtask.dao.repository.AdRepository;
import kz.redmadrobot.testtask.dao.repository.BetRepository;
import kz.redmadrobot.testtask.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetServiceImpl implements BetService {

    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final BetRepository betRepository;
    private final BetMapper betMapper;
    private final CreateBetMapper createBetMapper;

    @Override
    public BetDto create(CreateBetRequest request) {
        log.info("Creating bet on ad with id={} from user with id={}", request.getAdId(), request.getUserId());

        Bet lastBet = betRepository.findByAd_idAndIsPrimaryTrue(request.getAdId()).map(res -> {
            if (res.getOfferedPrice().compareTo(request.getOfferedPrice()) > 0) {
                throw new OfferedPriceIsLowerThanActualException();
            }
            res.setIsPrimary(false);
            return betRepository.save(res);
        }).orElse(null);


        log.info("Searching for ad by id={}", request.getAdId());
        Ad ad = adRepository.findById(request.getAdId()).map(res -> {
            if (res.getMinimalPrice().compareTo(request.getOfferedPrice()) > 0) {
                throw new OfferedPriceIsLowerThanActualException();
            }
            if (lastBet == null) {
                res.setUntil(LocalDateTime.now().plusSeconds(10));
            }
            if (res.getUntil().isBefore(LocalDateTime.now())) {
                throw new AdIsWithdrawnException();
            }
            return adRepository.save(res);
        }).orElseThrow(AdNotFoundException::new);

        log.info("Searching for user by id={}", request.getUserId());
        User user = userRepository.findById(request.getUserId()).map(res -> {
            if (lastBet != null) {
                String prevUserEmail = lastBet.getCreatedBy().get().getEmail();
                String prevUserOffer = lastBet.getOfferedPrice().toString();
                String currUserEmail = res.getEmail();
                String currUserOffer = request.getOfferedPrice().toString();

                log.info("User '{}' offered price {} was beaten by '{}' user with offer {}",
                        prevUserEmail, prevUserOffer, currUserEmail, currUserOffer);
            }
            return res;
        }).orElseThrow(UserNotFoundException::new);

        Bet bet = createBetMapper.toEntity(request);
        bet.setAd(ad);
        bet.setCreatedBy(user);
        bet.setIsPrimary(true);

        betRepository.save(bet);

        log.info("Bet created with id={}", bet.getId());
        return betMapper.toDto(bet);
    }
}