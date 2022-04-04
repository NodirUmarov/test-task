package domain.model;

import domain.model.enums.Direction;

import java.util.Queue;

public class Elevator {

    private int topFloor;
    private int currentFloor;
    private Direction direction;
    private int currentMaxCapacity;
    private Queue<Passenger> passengers;

    public Elevator(int topFloor, int currentFloor, int currentMaxCapacity, Queue<Passenger> passengers) {
        this.topFloor = topFloor;
        this.currentFloor = currentFloor;
        this.currentMaxCapacity = currentMaxCapacity;
        this.passengers = passengers;

        direction = Direction.WAITING;
    }

    public int getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(int topFloor) {
        this.topFloor = topFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentMaxCapacity() {
        return currentMaxCapacity;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCurrentMaxCapacity(int currentMaxCapacity) {
        this.currentMaxCapacity = currentMaxCapacity;
    }

    public Queue<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "topFloor=" + topFloor +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                ", currentMaxCapacity=" + currentMaxCapacity +
                ", passengers=" + passengers +
                '}';
    }
}
