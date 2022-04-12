package domain.service;

import domain.model.Building;
import domain.model.request.CreateBuildingRequest;

public interface BuildingService {
    Building create(CreateBuildingRequest request);
    Building findByName(String name);
}
