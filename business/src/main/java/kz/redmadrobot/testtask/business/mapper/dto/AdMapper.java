package kz.redmadrobot.testtask.business.mapper.dto;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface AdMapper extends EntityMapper<Ad, AdDto>, DtoMapper<Ad, AdDto> {
}
