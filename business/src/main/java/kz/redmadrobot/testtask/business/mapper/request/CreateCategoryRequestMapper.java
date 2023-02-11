package kz.redmadrobot.testtask.business.mapper.request;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.request.CreateCategoryRequest;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface CreateCategoryRequestMapper extends EntityMapper<Category, CreateCategoryRequest> {

}