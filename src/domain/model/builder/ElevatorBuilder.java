package domain.model.builder;

import domain.model.Elevator;
import domain.model.Passenger;

import java.util.Queue;

public class ElevatorBuilder {

    private int topFloor;
    private int currentFloor;
    private int currentMaxCapacity;
    private Queue<Passenger> passengers;

    private ElevatorBuilder() {}

    public static ElevatorBuilder builder() {
        return new ElevatorBuilder();
    }

    public Elevator build() {
        return new Elevator(topFloor, currentFloor, currentMaxCapacity, passengers);
    }

    public ElevatorBuilder setTopFloor(int topFloor) {
        this.topFloor = topFloor;
        return this;
    }

    public ElevatorBuilder setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        return this;
    }

    public ElevatorBuilder setCurrentMaxCapacity(int currentMaxCapacity) {
        this.currentMaxCapacity = currentMaxCapacity;
        return this;
    }

    public ElevatorBuilder setPassengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }
}
