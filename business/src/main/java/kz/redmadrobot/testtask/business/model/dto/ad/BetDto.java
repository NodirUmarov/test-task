package kz.redmadrobot.testtask.business.model.dto.ad;

import java.math.BigDecimal;

public record BetDto(AdDto ad, BigDecimal offeredPrice, Boolean isPrimary) {
}