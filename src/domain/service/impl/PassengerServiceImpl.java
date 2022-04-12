package domain.service.impl;

import domain.config.ApplicationContext;
import domain.dao.PassengerDao;
import domain.service.PassengerService;
import domain.model.Passenger;

public class PassengerServiceImpl implements PassengerService {

    private PassengerDao passengerDao;

    public PassengerServiceImpl() {
        this.passengerDao = ApplicationContext.getBean("passengerDao", PassengerDao.class);
    }

    public Passenger create(Passenger passenger) {
        return passengerDao.save(passenger);
    }
}
