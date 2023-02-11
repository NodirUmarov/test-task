package kz.redmadrobot.testtask.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserResource extends RepresentationModel<UserResource> {

    @JsonProperty
    @Schema(name = "ID", requiredMode = RequiredMode.AUTO, allowableValues = "[1, infinity]")
    private Long id;

    @JsonProperty
    @Schema(name = "email", requiredMode = RequiredMode.REQUIRED)
    private String email;

    @JsonProperty
    @Schema(name = "firstName", requiredMode = RequiredMode.NOT_REQUIRED)
    private String firstName;

    @JsonProperty
    @Schema(name = "lastName", requiredMode = RequiredMode.NOT_REQUIRED)
    private String lastName;

    @JsonProperty
    @Schema(name = "patronymic", requiredMode = RequiredMode.NOT_REQUIRED)
    private String patronymic;

    @JsonProperty
    @Schema(name = "dob", requiredMode = RequiredMode.NOT_REQUIRED)
    private LocalDate dob;

    @JsonCreator
    public UserResource(Long id, String email, String firstName, String lastName, String patronymic, LocalDate dob) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dob = dob;
    }
}
