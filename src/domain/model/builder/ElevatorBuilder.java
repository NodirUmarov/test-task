package domain.model.builder;

import domain.model.Building;
import domain.model.Elevator;
import domain.model.Floor;
import domain.model.Passenger;
import domain.model.enums.Direction;

import java.util.Queue;

public class ElevatorBuilder {

    private Long id;
    private Integer capacity;
    private Floor currentFloor;
    private Floor floorToGo;
    private Queue<Passenger> passengers;
    private Direction direction;
    private Building building;

    private ElevatorBuilder() {}

    public static ElevatorBuilder builder() {
        return new ElevatorBuilder();
    }

    public Elevator build() {
        return new Elevator(id, capacity, currentFloor, floorToGo, passengers, direction, building);
    }

    public ElevatorBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ElevatorBuilder capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public ElevatorBuilder currentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
        return this;
    }

    public ElevatorBuilder floorToGo(Floor floorToGo) {
        this.floorToGo = floorToGo;
        return this;
    }

    public ElevatorBuilder passengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }

    public ElevatorBuilder direction(Direction direction) {
        this.direction = direction;
        return this;
    }

    public ElevatorBuilder builder(Building building) {
        this.building = building;
        return this;
    }

}
