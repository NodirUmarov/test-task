package domain.service.impl;

import domain.model.Building;
import domain.model.Passenger;
import domain.model.enums.Direction;
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
import java.util.stream.Collectors;

public class BuildingServiceImpl implements BuildingService {

    private Building building;

    private PassengerService passengerService;
    private ElevatorService elevatorService;

    public BuildingServiceImpl() {
    }

    public BuildingServiceImpl(PassengerService passengerService, ElevatorService elevatorService) {
        this.passengerService = passengerService;
        this.elevatorService = elevatorService;
    }

    @Override
    public Building create(CreateBuildingRequest request) {
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

    public void print() {
        System.out.println("Elevator has reached next floor");
        String elevatorData = elevatorService
                .getCurrentElevator()
                .getPassengers()
                .stream()
                .map(passenger -> passenger.getDirection().name().charAt(0) + String.valueOf(passenger.getFloorToGo()))
                .collect(Collectors.joining(" "));

        if (elevatorService.getCurrentElevator().getDirection().equals(Direction.UP)) {
            elevatorData = "^ " + elevatorData + " ^";
        }
        else {
            elevatorData = "v " + elevatorData + " v";
        }

        for (int i = building.getFloors(); i > 0; i--) {
            String floorData = building
                    .getFloorsWithPassengers()
                    .get(i - 1).stream()
                    .map(passenger -> passenger.getDirection().name().charAt(0) + String.valueOf(passenger.getFloorToGo()))
                    .collect(Collectors.joining(" "));

            boolean elevatorAtThisLevel = building.getElevator().getCurrentFloor() == i;

            System.out.printf("" +
                    "%2d|%s|%-10s%n", i, elevatorAtThisLevel ? elevatorData : elevatorData.replaceAll(".", " "), floorData);
        }
        System.out.println();
    }

    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public void setElevatorService(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }
}
