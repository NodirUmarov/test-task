package kz.redmadrobot.testtask.business.mapper.dto;

import java.time.LocalDateTime;
import java.util.Optional;
import kz.redmadrobot.testtask.business.exception.NonNullablePropertyIsNullException;
import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.dao.entity.ad.Bet;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class, uses = {UserMapper.class})
public interface BetMapper extends EntityMapper<Bet, BetDto>, DtoMapper<Bet, BetDto> {

    default LocalDateTime toLocalDateTime(Optional<LocalDateTime> optionalLocalDateTime) {
        return optionalLocalDateTime.orElseThrow(() ->
                new NonNullablePropertyIsNullException("One of LocalDateTime properties of Bet entity is null"));
    }
}
