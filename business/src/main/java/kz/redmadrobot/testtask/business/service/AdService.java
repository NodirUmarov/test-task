package kz.redmadrobot.testtask.business.service;

import java.util.List;
import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.enums.AdFilterDetails;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;

public interface AdService {

    AdDto create(CreateAdRequest request);
    AdDto getOne(Long id);
    List<AdDto> getAll(Long from, Long to);
    List<AdDto> getAllContainingWord(Long from, Long to, String content, AdFilterDetails adFilterDetails);
}
