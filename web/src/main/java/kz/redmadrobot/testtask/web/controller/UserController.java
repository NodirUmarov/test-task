package kz.redmadrobot.testtask.web.controller;

import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.business.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getOne(id));
    }

}
