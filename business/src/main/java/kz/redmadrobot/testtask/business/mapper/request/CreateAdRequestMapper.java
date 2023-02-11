package kz.redmadrobot.testtask.business.mapper.request;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface CreateAdRequestMapper extends EntityMapper<Ad, CreateAdRequest> {

}
