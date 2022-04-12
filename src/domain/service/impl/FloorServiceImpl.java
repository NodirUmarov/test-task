package domain.service.impl;

import domain.config.ApplicationContext;
import domain.dao.FloorDao;
import domain.exceptions.ModelNotFoundException;
import domain.model.Floor;
import domain.service.FloorService;

public class FloorServiceImpl implements FloorService {

    private FloorDao floorDao;

    public FloorServiceImpl() {
        floorDao = ApplicationContext.getBean("floorDao", FloorDao.class);
    }

    @Override
    public Floor create(Floor floor) {
        return floorDao.save(floor);
    }
}
