package kz.redmadrobot.testtask.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import kz.redmadrobot.testtask.business.model.dto.enums.AdStatusDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AdResource extends RepresentationModel<AdResource> {


    @JsonProperty
    @Schema(name = "ID", requiredMode = RequiredMode.AUTO, allowableValues = "[1, infinity]")
    private Long id;

    @JsonProperty
    @Schema(name = "title", requiredMode = RequiredMode.REQUIRED)
    private String title;

    @JsonProperty
    @Schema(name = "description", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @JsonProperty
    @Schema(name = "minimalPrice", requiredMode = RequiredMode.REQUIRED)
    private BigDecimal minimalPrice;

    @JsonProperty
    @Schema(name = "adStatus", requiredMode = RequiredMode.REQUIRED)
    private AdStatusDto adStatus;

    @JsonProperty
    @Schema(name = "category", requiredMode = RequiredMode.REQUIRED)
    private CategoryResource category;

    @JsonProperty
    @Schema(name = "imageData", requiredMode = RequiredMode.REQUIRED)
    private byte[] imageData;

    @JsonProperty
    @Schema(name = "createdBy", requiredMode = RequiredMode.REQUIRED)
    private UserResource createdBy;

    @JsonProperty
    @Schema(name = "createdDate", requiredMode = RequiredMode.REQUIRED)
    private LocalDateTime createdDate;

    @JsonCreator
    public AdResource(Long id, String title, String description, BigDecimal minimalPrice, AdStatusDto adStatus, CategoryResource category, byte[] imageData, UserResource createdBy, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minimalPrice = minimalPrice;
        this.adStatus = adStatus;
        this.category = category;
        this.imageData = imageData;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }
}
