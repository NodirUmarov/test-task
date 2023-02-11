package kz.redmadrobot.testtask.web.assembler;

import kz.redmadrobot.testtask.business.model.dto.ad.CategoryDto;
import kz.redmadrobot.testtask.web.controller.CategoryController;
import kz.redmadrobot.testtask.web.model.CategoryResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class CategoryAssembler extends RepresentationModelAssemblerSupport<CategoryDto, CategoryResource> {

    private final UserAssembler userAssembler;

    public CategoryAssembler(UserAssembler userAssembler) {
        super(CategoryController.class, CategoryResource.class);
        this.userAssembler = userAssembler;
    }

    @Override
    public CategoryResource toModel(CategoryDto dto) {
        if (dto == null) {
            return null;
        }
        CategoryResource categoryResource = createModelWithId(dto.id(), dto);

        categoryResource.setId(dto.id());
        categoryResource.setName(dto.name());
        categoryResource.setCreatedDate(dto.createdDate());
        categoryResource.setParentCategory(toModel(dto.parentCategory()));
        categoryResource.setCreatedBy(userAssembler.toModel(dto.createdBy()));
        return categoryResource;
    }
}
