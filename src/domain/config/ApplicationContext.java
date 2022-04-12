package domain.config;

import domain.dao.BuildingDao;
import domain.dao.ElevatorDao;
import domain.dao.FloorDao;
import domain.dao.PassengerDao;
import domain.dao.impl.BuildingDaoImpl;
import domain.dao.impl.ElevatorDaoImpl;
import domain.dao.impl.FloorDaoImpl;
import domain.dao.impl.PassengerDaoImpl;
import domain.service.impl.BuildingServiceImpl;
import domain.service.impl.ElevatorServiceImpl;
import domain.service.impl.FloorServiceImpl;
import domain.service.impl.PassengerServiceImpl;

public class ApplicationContext {

    private static final BuildingServiceImpl buildingService;
    private static final ElevatorServiceImpl elevatorService;
    private static final PassengerServiceImpl passengerService;
    private static final FloorServiceImpl floorService;

    private static final BuildingDao buildingDao;
    private static final ElevatorDao elevatorDao;
    private static final PassengerDao passengerDao;
    private static final FloorDao floorDao;

    static {
        buildingService = new BuildingServiceImpl();
        passengerService = new PassengerServiceImpl();
        elevatorService = new ElevatorServiceImpl();
        floorService = new FloorServiceImpl();

        buildingDao = new BuildingDaoImpl();
        floorDao = new FloorDaoImpl();
        passengerDao = new PassengerDaoImpl();
        elevatorDao = new ElevatorDaoImpl();
    }

    private ApplicationContext() {
    }

    public static <T> T getBean(String beanName, Class<T> type) {
        switch (beanName) {
            case "buildingService":
                return type.cast(getBuildingService());
            case "elevatorService":
                return type.cast(getElevatorService());
            case "passengerService":
                return type.cast(getPassengerService());
            case "floorService":
                return type.cast(getFloorService());
            case "passengerDao":
                return type.cast(getPassengerDao());
            case "buildingDao":
                return type.cast(getBuildingDao());
            case "elevatorDao":
                return type.cast(getElevatorDao());
            case "floorDao":
                return type.cast(getFloorDao());
            default:
                throw new IllegalArgumentException("Bean not found: " + beanName);
        }
    }

    private static BuildingServiceImpl getBuildingService() {
        return buildingService;
    }

    private static ElevatorServiceImpl getElevatorService() {
        return elevatorService;
    }

    private static PassengerServiceImpl getPassengerService() {
        return passengerService;
    }

    private static FloorServiceImpl getFloorService() {
        return floorService;
    }

    private static BuildingDao getBuildingDao() {
        return buildingDao;
    }

    private static ElevatorDao getElevatorDao() {
        return elevatorDao;
    }

    private static PassengerDao getPassengerDao() {
        return passengerDao;
    }

    private static FloorDao getFloorDao() {
        return floorDao;
    }
}
