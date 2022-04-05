package domain.service;

import domain.service.impl.BuildingServiceImpl;
import domain.service.impl.ElevatorServiceImpl;
import domain.service.impl.PassengerServiceImpl;

public final class ServiceFactory {

    private static BuildingService buildingService;
    private static ElevatorService elevatorService;
    private static PassengerService passengerService;

    private ServiceFactory() {}

    public static BuildingService getBuildingService() {
        return buildingService == null ? buildingService = new BuildingServiceImpl() : buildingService;
    }

    public static ElevatorService getElevatorService(BuildingService buildingService) {
        return elevatorService == null ? elevatorService = new ElevatorServiceImpl(buildingService) : elevatorService;
    }

    public static PassengerService getPassengerService(BuildingService buildingService) {
        return passengerService == null ? passengerService = new PassengerServiceImpl(buildingService) : passengerService;
    }


}
