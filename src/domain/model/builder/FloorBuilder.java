package domain.model.builder;

import domain.model.Building;
import domain.model.Floor;
import domain.model.Passenger;

import java.util.Queue;

public class FloorBuilder {

    private Long id;
    private Queue<Passenger> passengers;
    private Integer floorNumber;
    private Building building;

    private FloorBuilder() {}

    public static FloorBuilder builder() {
        return new FloorBuilder();
    }

    public Floor build() {
        return new Floor(id, passengers, floorNumber, building);
    }

    public FloorBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public FloorBuilder passengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }

    public FloorBuilder floorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
        return this;
    }

    public FloorBuilder building(Building building) {
        this.building = building;
        return this;
    }

}
