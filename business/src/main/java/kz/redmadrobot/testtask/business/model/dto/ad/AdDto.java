package kz.redmadrobot.testtask.business.model.dto.ad;

import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;

import java.math.BigDecimal;

public record AdDto(String title, String description, BigDecimal minimalPrice,
                    AdStatusDto adStatus, CategoryDto category, byte[] imageData) {
}
