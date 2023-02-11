package kz.redmadrobot.testtask.business.mapper;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.mapper.dto.AdMapper;
import kz.redmadrobot.testtask.business.mapper.dto.UserMapper;
import kz.redmadrobot.testtask.business.model.request.CreateBetRequest;
import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class, uses = {AdMapper.class, UserMapper.class})
public interface CreateBetMapper extends EntityMapper<Bet, CreateBetRequest> {
}
