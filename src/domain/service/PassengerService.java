package domain.service;

import domain.model.Passenger;
import domain.model.request.CreateBuildingRequest;

public interface PassengerService {
    Passenger create(int count);
    Passenger changePassengerFloor(Passenger passenger);
}
