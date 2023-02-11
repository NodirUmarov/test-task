package kz.redmadrobot.testtask.business.service;

import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;

public interface AdService {

    AdDto create(CreateAdRequest request);

}
