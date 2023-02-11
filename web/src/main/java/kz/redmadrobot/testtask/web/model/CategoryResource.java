package kz.redmadrobot.testtask.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CategoryResource extends RepresentationModel<CategoryResource> {


    @JsonProperty
    @Schema(name = "ID", requiredMode = RequiredMode.AUTO, allowableValues = "[1, infinity]")
    private Long id;

    @JsonProperty
    @Schema(name = "name", requiredMode = RequiredMode.REQUIRED)
    private String name;

    @JsonProperty
    @Schema(name = "parentCategory", requiredMode = RequiredMode.REQUIRED)
    private CategoryResource parentCategory;

    @JsonProperty
    @Schema(name = "createdBy", requiredMode = RequiredMode.REQUIRED)
    private UserResource createdBy;

    @JsonProperty
    @Schema(name = "createdDate", requiredMode = RequiredMode.REQUIRED)
    private LocalDateTime createdDate;

    @JsonCreator
    public CategoryResource(Long id, String name, CategoryResource parentCategory, UserResource createdBy, LocalDateTime createdDate) {
        this.id = id;
        this.name = name;
        this.parentCategory = parentCategory;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }
}
