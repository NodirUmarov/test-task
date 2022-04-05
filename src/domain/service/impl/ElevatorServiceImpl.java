package domain.service.impl;

import domain.model.Elevator;
import domain.model.Passenger;
import domain.model.builder.ElevatorBuilder;
import domain.model.enums.Direction;
import domain.service.BuildingService;
import domain.service.ElevatorService;
import domain.service.PassengerService;
import domain.service.ServiceFactory;

import java.util.*;

public class ElevatorServiceImpl implements ElevatorService {

    private BuildingService buildingService;
    private PassengerService passengerService;
    private Elevator elevator;

    public ElevatorServiceImpl() {
    }

    public ElevatorServiceImpl(BuildingService buildingService, PassengerService passengerService) {
        this.buildingService = buildingService;
        this.passengerService = passengerService;
    }

    @Override
    public Elevator create(int capacity) {
        checkCapacity(capacity);
        PriorityQueue<Passenger> passengers = new PriorityQueue<>();

        return elevator = ElevatorBuilder
                .builder()
                .currentMaxCapacity(capacity)
                .currentFloor(1)
                .passengers(passengers)
                .topFloor(1)
                .build();
    }

    public Elevator nextFloor() {
        pickPassengers();
        Queue<Passenger> passengers = elevator.getPassengers();
        if (!passengers.isEmpty()) {
            elevator.setCurrentFloor(passengers.peek().getFloorToGo());
        } else {
            findNextRequestedFloor();
        }
        checkTopFloor();
        return elevator;
    }

    private int findNextRequestedFloor() {
        List<Queue<Passenger>> floorsWithPassengers = buildingService.getCurrentBuilding().getFloorsWithPassengers();
        for (int i = 1; i < floorsWithPassengers.size(); i++) {
            if (!floorsWithPassengers.get(i).isEmpty()) {
                return i + 1;
            }
        }
        return 0;
    }

    private void checkTopFloor() {
        int topFloor = elevator.getCurrentFloor();
        Optional<Passenger> optionalPassenger = elevator.getPassengers().stream().max(Comparator.naturalOrder());
        if (optionalPassenger.isPresent()) {
            topFloor = optionalPassenger.get().getFloorToGo();
        } else if (elevator.getCurrentFloor() != 1) {
            elevator.setDirection(Direction.DOWN);
        }
        elevator.setTopFloor(topFloor);
    }

    private void pickPassengers() {
        dropPassengers();
        int currentFloor = elevator.getCurrentFloor();
        Queue<Passenger> passengerQueue = buildingService.getCurrentBuilding().getFloorsWithPassengers().get(currentFloor - 1);

        Queue<Passenger> passengersPicked = elevator.getPassengers();

        while (!passengerQueue.isEmpty() && passengersPicked.size() < elevator.getCurrentMaxCapacity()) {
            Passenger passenger = passengerQueue.remove();
            if (!elevator.getDirection().equals(passenger.getDirection())) {
                continue;
            }
            passengersPicked.offer(passenger);
            elevator.setPassengers(passengersPicked);
            buildingService.getCurrentBuilding().setElevator(elevator);
        }
    }

    private void dropPassengers() {
        if (elevator.getPassengers().isEmpty()) {
            return;
        }
        Queue<Passenger> passengers = elevator.getPassengers();
        while (!passengers.isEmpty()) {
            if (passengers.peek().getFloorToGo() > elevator.getCurrentFloor()) {
                break;
            }
            if (passengers.peek().getFloorToGo() == elevator.getCurrentFloor()) {
                Passenger passenger = passengerService.changePassengerFloor(passengers.poll());
                buildingService.getCurrentBuilding().getFloorsWithPassengers().get(elevator.getCurrentFloor()).add(passenger);
            }
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity < 1 || capacity > 8) {
            throw new IllegalArgumentException("Elevator capacity from 1 to 8");
        }
    }

    public Elevator getCurrentElevator() {
        return elevator;
    }
}
