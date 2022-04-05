import domain.model.Building;
import domain.model.Passenger;
import domain.model.request.CreateBuildingRequest;
import domain.service.BuildingService;
import domain.service.ElevatorService;
import domain.service.ServiceFactory;

import java.util.Queue;


public class Main {

    public static void main(String[] args) {
        BuildingService buildingService = ServiceFactory.getBuildingService();
        Building building = buildingService.create(new CreateBuildingRequest(20, 8));

        ElevatorService elevatorService = ServiceFactory.getElevatorService();
        elevatorService.nextFloor();

        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();

        elevatorService.nextFloor();
        buildingService.print();
    }
}
