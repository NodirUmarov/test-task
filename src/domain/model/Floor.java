package domain.model;

import java.util.Queue;

public class Floor {

    private Long id;
    private Queue<Passenger> passengers;
    private Integer floorNumber;
    private Building building;

    public Floor() {
    }

    public Floor(Long id, Queue<Passenger> passengers, Integer floorNumber, Building building) {
        this.id = id;
        this.passengers = passengers;
        this.floorNumber = floorNumber;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Queue<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Queue<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", passengers=" + passengers +
                ", floorNumber=" + floorNumber +
                ", building=" + building +
                '}';
    }
}
