package kz.redmadrobot.testtask.business.model.dto.user;

import java.io.Serializable;
import java.time.LocalDate;

public record UserDto(Long id, String email, String password, RoleDto role, String firstName,
                      String lastName, String patronymic, LocalDate dob) implements Serializable {
}