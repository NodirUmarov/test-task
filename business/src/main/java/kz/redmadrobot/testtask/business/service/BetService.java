package kz.redmadrobot.testtask.business.service;

import kz.redmadrobot.testtask.business.model.dto.ad.BetDto;
import kz.redmadrobot.testtask.business.model.request.CreateBetRequest;

public interface BetService {

    BetDto create(CreateBetRequest request);
}
