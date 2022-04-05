package domain.service;

import domain.model.Building;
import domain.model.request.CreateBuildingRequest;

public interface BuildingService {
    Building create(CreateBuildingRequest count);
    Building getCurrentBuilding();
}
