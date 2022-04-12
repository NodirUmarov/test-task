package domain.service.impl;

import domain.config.ApplicationContext;
import domain.dao.ElevatorDao;
import domain.model.Elevator;
import domain.service.ElevatorService;

public class ElevatorServiceImpl implements ElevatorService {

    private ElevatorDao elevatorDao;

    public ElevatorServiceImpl() {
        this.elevatorDao = ApplicationContext.getBean("elevatorDao", ElevatorDao.class);
    }

    public Elevator create(Elevator elevator) {
        return elevatorDao.save(elevator);
    }

    @Override
    public Elevator nextFloor() {
        return null;
    }

}
