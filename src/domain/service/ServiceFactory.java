package domain.service;

import domain.service.impl.BuildingServiceImpl;
import domain.service.impl.ElevatorServiceImpl;
import domain.service.impl.PassengerServiceImpl;

public final class ServiceFactory {

    private static final BuildingService buildingService;
    private static final ElevatorService elevatorService;
    private static final PassengerService passengerService;

    static {
        buildingService = new BuildingServiceImpl();
        passengerService = new PassengerServiceImpl(buildingService);
        elevatorService = new ElevatorServiceImpl(buildingService, passengerService);

        buildingService.setElevatorService(elevatorService);
        buildingService.setPassengerService(passengerService);
    }

    private ServiceFactory() {}

    public static BuildingService getBuildingService() {
        return buildingService;
    }

    public static ElevatorService getElevatorService() {
        return elevatorService;
    }

    public static PassengerService getPassengerService() {
        return passengerService;
    }


}
