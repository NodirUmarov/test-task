package kz.redmadrobot.testtask.business.model.dto.ad;

import java.io.Serializable;
import java.math.BigDecimal;

public record BetDto(Long id, AdDto ad, BigDecimal offeredPrice, Boolean isPrimary) implements Serializable {
}