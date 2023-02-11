package kz.redmadrobot.testtask.business.mapper.dto;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface BetMapper extends EntityMapper<Bet, BetDto>, DtoMapper<Bet, BetDto> {
}
