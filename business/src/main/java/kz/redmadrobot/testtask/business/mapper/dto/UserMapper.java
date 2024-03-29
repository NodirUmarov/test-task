package kz.redmadrobot.testtask.business.mapper.dto;

import java.util.Optional;
import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.DtoMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface UserMapper extends EntityMapper<User, UserDto>, DtoMapper<User, UserDto> {

    default User toUser(Optional<User> optionalUser) {
        return optionalUser.orElseThrow(UserNotFoundException::new);
    }
}
