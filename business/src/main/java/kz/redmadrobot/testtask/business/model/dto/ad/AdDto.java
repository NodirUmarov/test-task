package kz.redmadrobot.testtask.business.model.dto.ad;

import java.time.LocalDateTime;
import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;

import java.math.BigDecimal;
import kz.redmadrobot.testtask.business.model.dto.user.UserDto;

public record AdDto(Long id, String title, String description, BigDecimal minimalPrice,
                    AdStatusDto adStatus, CategoryDto category, byte[] imageData, UserDto createdBy,
                    LocalDateTime createdDate, LocalDateTime until) {
}