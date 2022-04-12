package domain.model.builder;

import domain.model.Floor;
import domain.model.Passenger;
import domain.model.enums.Direction;

public class PassengerBuilder {

    private Long id;
    private String name;
    private Floor floorToGo;
    private Floor currentFloor;
    private Direction direction;

    private PassengerBuilder() {}

    public static PassengerBuilder builder() {
        return new PassengerBuilder();
    }

    public Passenger build() {
        return new Passenger(id, name, floorToGo, currentFloor, direction);
    }

    public PassengerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PassengerBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PassengerBuilder floorToGo(Floor floorToGo) {
        this.floorToGo = floorToGo;
        return this;
    }

    public PassengerBuilder currentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
        return this;
    }

    public PassengerBuilder direction(Direction direction) {
        this.direction = direction;
        return this;
    }
}
