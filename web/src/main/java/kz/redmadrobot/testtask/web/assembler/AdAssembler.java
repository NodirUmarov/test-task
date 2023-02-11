package kz.redmadrobot.testtask.web.assembler;

import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.web.controller.AdController;
import kz.redmadrobot.testtask.web.model.AdResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class AdAssembler extends RepresentationModelAssemblerSupport<AdDto, AdResource> {

    private final CategoryAssembler categoryAssembler;
    private final UserAssembler userAssembler;

    public AdAssembler(CategoryAssembler categoryAssembler, UserAssembler userAssembler) {
        super(AdController.class, AdResource.class);
        this.categoryAssembler = categoryAssembler;
        this.userAssembler = userAssembler;
    }

    @Override
    public AdResource toModel(AdDto dto) {
        AdResource adResource = createModelWithId(dto.id(), dto);

        adResource.setId(dto.id());
        adResource.setAdStatus(dto.adStatus());
        adResource.setTitle(dto.title());
        adResource.setMinimalPrice(dto.minimalPrice());
        adResource.setDescription(dto.description());
        adResource.setCreatedDate(dto.createdDate());
        adResource.setImageData(dto.imageData());
        adResource.setCreatedBy(userAssembler.toModel(dto.createdBy()));
        adResource.setCategory(categoryAssembler.toModel(dto.category()));
        return adResource;
    }
}
