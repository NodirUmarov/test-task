package kz.redmadrobot.testtask.web.assembler;

import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.web.controller.BetController;
import kz.redmadrobot.testtask.web.model.BetResource;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BetAssembler extends RepresentationModelAssemblerSupport<BetDto, BetResource> {

    private final AdAssembler adAssembler;

    public BetAssembler(AdAssembler adAssembler) {
        super(BetController.class, BetResource.class);
        this.adAssembler = adAssembler;
    }

    @Override
    public BetResource toModel(BetDto dto) {
        BetResource betResource = createModelWithId(dto.id(), dto);
        betResource.setId(dto.id());
        betResource.setAd(adAssembler.toModel(dto.ad()));
        betResource.setIsPrimary(dto.isPrimary());
        betResource.setOfferedPrice(dto.offeredPrice());
        return betResource;
    }
}
