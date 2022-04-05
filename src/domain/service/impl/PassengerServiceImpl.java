package domain.service.impl;

import domain.model.Building;
import domain.model.Passenger;
import domain.model.enums.Direction;
import domain.service.BuildingService;
import domain.service.PassengerService;
import domain.util.RandomGenerator;

public class PassengerServiceImpl implements PassengerService {

    private BuildingService buildingService;

    public PassengerServiceImpl() {
    }

    public PassengerServiceImpl(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    public Passenger create(int currentFloor) {
        Passenger passenger = new Passenger();
        passenger.setCurrentFloor(currentFloor);
        return changePassengerFloor(passenger);
    }

    public Passenger changePassengerFloor(Passenger passenger) {
        int randomFloorToGo = RandomGenerator.getRandomWithExclusion(Building.GROUND_FLOOR, buildingService.getCurrentBuilding().getFloors(), passenger.getCurrentFloor());
        Direction direction = passenger.getCurrentFloor() > randomFloorToGo ? Direction.DOWN : Direction.UP;

        passenger.setDirection(direction);
        passenger.setFloorToGo(randomFloorToGo);
        return passenger;
    }
}
