package kz.redmadrobot.testtask.business.model.dto.user;

import java.time.LocalDate;

public record UserDto(Long id, String email, String password, String firstName,
                      String lastName, String patronymic, LocalDate dob) {
}