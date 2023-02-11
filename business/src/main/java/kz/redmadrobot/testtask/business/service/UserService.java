package kz.redmadrobot.testtask.business.service;

import kz.redmadrobot.testtask.business.model.dto.user.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto getOne(Long id);
}
