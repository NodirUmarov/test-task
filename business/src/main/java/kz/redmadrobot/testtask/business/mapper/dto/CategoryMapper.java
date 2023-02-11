package kz.redmadrobot.testtask.business.mapper.dto;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.dao.entity.ad.Category;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface CategoryMapper  extends EntityMapper<Category, CategoryDto>, DtoMapper<Category, CategoryDto> {
}
