package domain.model;

import domain.model.enums.Direction;

import java.util.Queue;

public class Elevator {

    private Long id;
    private Integer capacity;
    private Floor currentFloor;
    private Floor floorToGo;
    private Queue<Passenger> passengers;
    private Direction direction;
    private Building building;

    public Elevator(Long id, Integer capacity, Floor currentFloor, Floor floorToGo, Queue<Passenger> passengers, Direction direction, Building building) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = currentFloor;
        this.floorToGo = floorToGo;
        this.passengers = passengers;
        this.direction = direction;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Floor getFloorToGo() {
        return floorToGo;
    }

    public void setFloorToGo(Floor floorToGo) {
        this.floorToGo = floorToGo;
    }

    public Queue<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", currentFloor=" + currentFloor +
                ", floorToGo=" + floorToGo +
                ", passengers=" + passengers +
                ", direction=" + direction +
                ", building=" + building +
                '}';
    }
}
