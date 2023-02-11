package kz.redmadrobot.testtask.business.service;

import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.business.model.request.CreateUserRequest;

public interface UserService {
    UserDto create(CreateUserRequest request);
    UserDto getOne(Long id);
}
