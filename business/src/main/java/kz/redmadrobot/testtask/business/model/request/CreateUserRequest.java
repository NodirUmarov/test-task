package kz.redmadrobot.testtask.business.model.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String password;
    private Long roleId;
}
