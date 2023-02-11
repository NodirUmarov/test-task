package kz.redmadrobot.testtask.business.service.impl;

import kz.redmadrobot.testtask.business.exception.CategoryNotFoundException;
import kz.redmadrobot.testtask.business.mapper.dto.CategoryMapper;
import kz.redmadrobot.testtask.business.mapper.request.CreateCategoryRequestMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.request.CreateCategoryRequest;
import kz.redmadrobot.testtask.business.service.CategoryService;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import kz.redmadrobot.testtask.dao.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CreateCategoryRequestMapper createCategoryRequestMapper;

    @Override
    public CategoryDto create(CreateCategoryRequest request) {
        log.info("Creating category with name='{}'", request.getName());

        Category category = createCategoryRequestMapper.toEntity(request);

        if (request.getParentCategoryId() != null) {
            log.info("Searching for parent category by id={}", request.getParentCategoryId());
            Category parent = categoryRepository.findById(request.getParentCategoryId())
                    .orElseThrow(CategoryNotFoundException::new);

            category.setParentCategory(parent);
        } else {
            log.info("Parent category id is null, no parent will be provided");
        }

        categoryRepository.save(category);
        log.info("Category saved and id={} assigned", category.getId());
        return categoryMapper.toDto(category);
    }
}
