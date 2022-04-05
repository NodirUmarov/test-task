package domain.model.builder;

import domain.model.Passenger;
import domain.model.enums.Direction;
import domain.model.request.CreateBuildingRequest;

public class PassengerBuilder {

    private int floorToGo;
    private int currentFloor;
    private Direction direction;

    private PassengerBuilder() {}

    public static PassengerBuilder builder() {
        return new PassengerBuilder();
    }

    public Passenger build() {
        return new Passenger(floorToGo, currentFloor, direction);
    }

    public PassengerBuilder floorToGo(int floorToGo) {
        this.floorToGo = floorToGo;
        return this;
    }

    public PassengerBuilder currentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        return this;
    }

    public PassengerBuilder direction(Direction direction) {
        this.direction = direction;
        return this;
    }
}
