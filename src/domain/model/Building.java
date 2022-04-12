package domain.model;

import java.util.Queue;

public class Building {

    private String name;
    private Queue<Floor> floorsWithPassengers;
    private Integer topFloor;
    private Elevator elevators;

    public Building(String name, Queue<Floor> floorsWithPassengers, Integer topFloor, Elevator elevators) {
        this.name = name;
        this.floorsWithPassengers = floorsWithPassengers;
        this.topFloor = topFloor;
        this.elevators = elevators;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Floor> getFloorsWithPassengers() {
        return floorsWithPassengers;
    }

    public void setFloorsWithPassengers(Queue<Floor> floorsWithPassengers) {
        this.floorsWithPassengers = floorsWithPassengers;
    }

    public Integer getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(Integer topFloor) {
        this.topFloor = topFloor;
    }

    public Elevator getElevators() {
        return elevators;
    }

    public void setElevators(Elevator elevators) {
        this.elevators = elevators;
    }

    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", floorsWithPassengers=" + floorsWithPassengers +
                ", topFloor=" + topFloor +
                ", elevators=" + elevators +
                '}';
    }
}