package kz.redmadrobot.testtask.business.mapper.request;

import kz.redmadrobot.testtask.business.mapper.config.AutowireMapper;
import kz.redmadrobot.testtask.business.mapper.config.EntityMapper;
import kz.redmadrobot.testtask.business.model.request.CreateUserRequest;
import kz.redmadrobot.testtask.dao.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(config = AutowireMapper.class)
public interface CreateUserMapper extends EntityMapper<User, CreateUserRequest> {
}
