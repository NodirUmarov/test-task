package kz.redmadrobot.testtask.business.service;

import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.business.model.request.CreateCategoryRequest;

public interface CategoryService {
    CategoryDto create(CreateCategoryRequest request);
}
