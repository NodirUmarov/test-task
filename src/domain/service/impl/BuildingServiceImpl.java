package domain.service.impl;

import domain.config.ApplicationContext;
import domain.dao.BuildingDao;
import domain.model.Building;
import domain.model.Elevator;
import domain.model.Floor;
import domain.model.Passenger;
import domain.model.builder.BuildingBuilder;
import domain.model.builder.ElevatorBuilder;
import domain.model.builder.FloorBuilder;
import domain.model.builder.PassengerBuilder;
import domain.model.enums.Direction;
import domain.model.request.CreateBuildingRequest;
import domain.service.BuildingService;
import domain.service.ElevatorService;
import domain.service.FloorService;
import domain.service.PassengerService;
import domain.util.RandomGenerator;

import java.util.*;

public class BuildingServiceImpl implements BuildingService {

    private BuildingDao buildingDao;
    private ElevatorService elevatorService;
    private FloorService floorService;
    private PassengerService passengerService;

    public BuildingServiceImpl() {
        this.buildingDao = ApplicationContext.getBean("buildingDao", BuildingDao.class);
        this.elevatorService = ApplicationContext.getBean("elevatorService", ElevatorService.class);
        this.floorService = ApplicationContext.getBean("floorService", FloorService.class);
        this.passengerService = ApplicationContext.getBean("passengerService", PassengerService.class);
    }

    @Override
    public Building create(CreateBuildingRequest request) {
        LinkedList<Floor> floors = new LinkedList<>();

        for (int floorNumber = 1; floorNumber <= request.getTopFloor(); floorNumber++) {
            Floor floor = FloorBuilder
                    .builder()
                    .passengers(new ArrayDeque<>())
                    .floorNumber(floorNumber)
                    .build();
            floors.add(floorService.create(floor));
        }

        for (int floorNumber = 0; floorNumber < floors.size(); floorNumber++) {
            Floor currentFloor = floors.get(floorNumber);

            int passengersOnFloor = RandomGenerator.getRandom(0, 11);

            for (int passengerCount = 0; passengerCount < passengersOnFloor; passengerCount++) {

                Direction direction = Direction.values()[RandomGenerator.getRandom(0, 2)];
                Floor floorToGo = floors.get(RandomGenerator.getRandomWithExclusion(0, request.getTopFloor(), floorNumber));

                Passenger passenger = PassengerBuilder
                        .builder()
                        .direction(direction)
                        .name(RandomGenerator.getRandomName())
                        .currentFloor(currentFloor)
                        .floorToGo(floorToGo)
                        .build();

                currentFloor.getPassengers().add(passengerService.create(passenger));
            }
        }
        Elevator elevator = ElevatorBuilder
                .builder()
                .capacity(request.getElevatorCapacity())
                .currentFloor(floors.getFirst())
                .passengers(new PriorityQueue<>())
                .build();

        elevatorService.create(elevator);

        Building building = BuildingBuilder
                .builder()
                .floorsWithPassengers(floors)
                .elevator(elevator)
                .name(request.getName())
                .topFloor(request.getTopFloor())
                .build();

        return buildingDao.save(building);
    }

    @Override
    public Building findByName(String name) {
        return null;
    }
}
