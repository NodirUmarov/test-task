package domain.service;

import domain.model.Elevator;
import domain.model.request.CreateBuildingRequest;

public interface ElevatorService {
    Elevator create(int capacity);
    Elevator nextFloor();
    Elevator getCurrentElevator();
}
