package domain.service.impl;

import domain.model.Building;
import domain.model.Passenger;
import domain.model.request.CreateBuildingRequest;
import domain.service.BuildingService;
import domain.service.ElevatorService;
import domain.service.PassengerService;
import domain.service.ServiceFactory;
import domain.util.RandomGenerator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

public class BuildingServiceImpl implements BuildingService {

    private Building building;

    private Logger log;
    private PassengerService passengerService;
    private ElevatorService elevatorService;

    public BuildingServiceImpl() {
        log = Logger.getLogger(this.getClass().getName());
        this.passengerService = ServiceFactory.getPassengerService(this);
        this.elevatorService = ServiceFactory.getElevatorService(this);
    }

    @Override
    public Building create(CreateBuildingRequest request) {
        log.entering(this.getClass().getName(), "create()", request.getFloorsNumber());
        checkFloors(request.getFloorsNumber());
        List<Queue<Passenger>> floors = new ArrayList<>(request.getFloorsNumber());

        building = new Building(request.getFloorsNumber(), floors);

        for (int i = 0; i < request.getFloorsNumber(); i++) {

            Queue<Passenger> passengerQueue = new ArrayDeque<>();
            int passengersCount = RandomGenerator.getRandom(0, 11);

            for (int j = 0; j < passengersCount; j++) {
                int currentFloor = i + 1;
                passengerQueue.offer(passengerService.create(currentFloor));
            }
            floors.add(passengerQueue);
            building.setElevator(elevatorService.create(request.getElevatorMaxCapacity()));
        }
        return building;
    }

    private void checkFloors(int floorsNumber) {
        if (floorsNumber > 20 || floorsNumber < 5) {
            throw new IllegalArgumentException("Building can have from 5 to 20 floors");
        }
    }

    public Building getCurrentBuilding() {
        return building;
    }
}
