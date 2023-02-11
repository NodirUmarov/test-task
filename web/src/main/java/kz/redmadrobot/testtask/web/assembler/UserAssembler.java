package kz.redmadrobot.testtask.web.assembler;

import kz.redmadrobot.testtask.business.model.dto.user.UserDto;
import kz.redmadrobot.testtask.web.controller.UserController;
import kz.redmadrobot.testtask.web.model.UserResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserResource> {

    public UserAssembler() {
        super(UserController.class, UserResource.class);
    }

    @Override
    public UserResource toModel(UserDto dto) {
        UserResource userResource = createModelWithId(dto.id(), dto);

        userResource.setId(dto.id());
        userResource.setFirstName(dto.firstName());
        userResource.setDob(dto.dob());
        userResource.setLastName(dto.lastName());
        userResource.setPatronymic(dto.patronymic());
        userResource.setEmail(dto.email());
        return userResource;
    }
}
