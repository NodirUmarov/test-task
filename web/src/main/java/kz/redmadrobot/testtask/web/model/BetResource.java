package kz.redmadrobot.testtask.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BetResource extends RepresentationModel<BetResource> {


    @JsonProperty
    @Schema(name = "ID", requiredMode = RequiredMode.REQUIRED, allowableValues = "[1, infinity]")
    private Long id;

    @JsonProperty
    @Schema(name = "ad", requiredMode = RequiredMode.REQUIRED)
    private AdResource ad;

    @JsonProperty
    @Schema(name = "offeredPrice", requiredMode = RequiredMode.REQUIRED)
    private BigDecimal offeredPrice;

    @JsonProperty
    @Schema(name = "isPrimary", requiredMode = RequiredMode.REQUIRED)
    private Boolean isPrimary;

    @JsonCreator
    public BetResource(Long id, AdResource ad, BigDecimal offeredPrice, Boolean isPrimary) {
        this.id = id;
        this.ad = ad;
        this.offeredPrice = offeredPrice;
        this.isPrimary = isPrimary;
    }
}
