import model.Building;
import model.Floor;
import model.request.NextFloorRequest;
import service.BuildingService;
import service.ElevatorService;
import service.FloorService;
import service.PassengerService;

import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BuildingService buildingService = new BuildingService();
        FloorService floorService = new FloorService();
        PassengerService passengerService = new PassengerService();
        ElevatorService elevatorService = new ElevatorService();

        buildingService.setFloorService(floorService);
        floorService.setPassengerService(passengerService);

        buildingService.create();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Building to get: ");
        Building building = buildingService.getBuilding(scanner.nextLine());

        ListIterator<Floor> listIterator = building.getFloorsWithPassengers().listIterator(1);
        while (listIterator.hasNext()) {
            NextFloorRequest request = new NextFloorRequest(building.getElevator(), listIterator.next(), building.getTopFloor());
            System.out.println(building);
            System.out.println("\n");
            elevatorService.nextFloor(request);
        }

        while (listIterator.hasPrevious()) {
            NextFloorRequest request = new NextFloorRequest(building.getElevator(), listIterator.previous(), building.getTopFloor());
            System.out.println(building);
            System.out.println("\n");
            elevatorService.nextFloor(request);
        }
        System.out.println(building);

    }
}
