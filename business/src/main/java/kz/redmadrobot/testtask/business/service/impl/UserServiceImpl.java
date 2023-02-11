package kz.redmadrobot.testtask.business.service.impl;

import kz.redmadrobot.testtask.business.exception.UserNotFoundException;
import kz.redmadrobot.testtask.business.mapper.dto.UserMapper;
import kz.redmadrobot.testtask.business.mapper.request.CreateUserMapper;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.business.model.request.CreateUserRequest;
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
    private final CreateUserMapper createUserMapper;

    @Override
    public UserDto create(CreateUserRequest request) {
        log.info("Creating new user with email: {}", request.getEmail());

        User user = userRepository.save(createUserMapper.toEntity(request));

        log.info("User with email {} created and id={} assigned", user.getEmail(), user.getId());
        return userMapper.toDto(user);
    }

    @Override
    public UserDto getOne(Long id) {
        log.info("Searching for user by id={}", id);
        return userMapper.toDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public UserDto getOneByEmail(String username) {
        log.info("Searching for user by name='{}'", username);
        return userMapper.toDto(userRepository.findByEmail(username).orElseThrow(UserNotFoundException::new));
    }


}
