package kz.redmadrobot.testtask.business.mapper.dto;

import java.time.LocalDateTime;
import java.util.Optional;
import kz.redmadrobot.testtask.business.exception.NonNullablePropertyIsNullException;
import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.dao.entity.ad.Ad;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class, uses = {UserMapper.class, CategoryMapper.class})
public interface AdMapper extends EntityMapper<Ad, AdDto>, DtoMapper<Ad, AdDto> {

    default LocalDateTime toLocalDateTime(Optional<LocalDateTime> optionalLocalDateTime) {
        return optionalLocalDateTime.orElseThrow(() ->
                new NonNullablePropertyIsNullException("One of LocalDateTime properties of Ad entity is null"));
    }

}
