package domain.model;

import domain.model.enums.Direction;

public class Passenger implements Comparable<Passenger> {

    private Long id;
    private String name;
    private Floor floorToGo;
    private Floor currentFloor;
    private Direction direction;

    public Passenger(Long id, String name, Floor floorToGo, Floor currentFloor, Direction direction) {
        this.id = id;
        this.name = name;
        this.floorToGo = floorToGo;
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Floor getFloorToGo() {
        return floorToGo;
    }

    public void setFloorToGo(Floor floorToGo) {
        this.floorToGo = floorToGo;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public int compareTo(Passenger other) {
        if (this.floorToGo.getFloorNumber() < other.floorToGo.getFloorNumber()) {
            return -1;
        }
        if (this.floorToGo.getFloorNumber() > other.floorToGo.getFloorNumber()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floorToGo=" + floorToGo +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }
}
