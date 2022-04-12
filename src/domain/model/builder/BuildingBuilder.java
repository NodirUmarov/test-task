package domain.model.builder;

import domain.model.Building;
import domain.model.Elevator;
import domain.model.Floor;

import java.util.Queue;

public class BuildingBuilder {

    private String name;
    private Queue<Floor> floorsWithPassengers;
    private Integer topFloor;
    private Elevator elevators;

    private BuildingBuilder() {}

    public static BuildingBuilder builder() {
        return new BuildingBuilder();
    }

    public Building build() {
        return new Building(name, floorsWithPassengers, topFloor, elevators);
    }

    public BuildingBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BuildingBuilder floorsWithPassengers(Queue<Floor> floorsWithPassengers) {
        this.floorsWithPassengers = floorsWithPassengers;
        return this;
    }

    public BuildingBuilder topFloor(Integer topFloor) {
        this.topFloor = topFloor;
        return this;
    }

    public BuildingBuilder elevator(Elevator elevators) {
        this.elevators = elevators;
        return this;
    }

}
