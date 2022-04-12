package domain.service;

import domain.model.Elevator;

public interface ElevatorService {
    Elevator create(Elevator elevator);
    Elevator nextFloor();
}
