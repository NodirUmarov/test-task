package kz.redmadrobot.testtask.business.service.impl;

import kz.redmadrobot.testtask.business.mapper.dto.UserMapper;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.business.service.UserService;
import kz.redmadrobot.testtask.dao.entity.user.User;
import kz.redmadrobot.testtask.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        log.info("Creating new user with email: {}", userDto.email());

        User user = userRepository.save(userMapper.toEntity(userDto));

        log.info("User with email {} created and id={} assigned", user.getEmail(), user.getId());
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getOne(Long id) {
        log.info("Searching for user by id={}", id);
        return userMapper.toDto(userRepository.findById(id).orElse(new User()));
    }
}
