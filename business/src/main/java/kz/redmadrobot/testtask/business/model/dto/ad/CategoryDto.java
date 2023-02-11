package kz.redmadrobot.testtask.business.model.dto.ad;

import java.io.Serializable;
import java.time.LocalDateTime;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;

public record CategoryDto(Long id, String name, CategoryDto parentCategory, UserDto createdBy, LocalDateTime createdDate)
        implements Serializable {
}