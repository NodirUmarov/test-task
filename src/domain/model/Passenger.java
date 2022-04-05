package domain.model;

import domain.model.enums.Direction;

public class Passenger implements Comparable<Passenger> {

    private int floorToGo;
    private int currentFloor;
    private Direction direction;

    public Passenger() {
    }

    public Passenger(int floorToGo, int currentFloor, Direction direction) {
        this.floorToGo = floorToGo;
        this.currentFloor = currentFloor;
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getFloorToGo() {
        return floorToGo;
    }

    public void setFloorToGo(int floorToGo) {
        this.floorToGo = floorToGo;
    }

    @Override
    public int compareTo(Passenger other) {
        return direction == Direction.UP ?
                Integer.compare(this.floorToGo, other.floorToGo) :
                Integer.compare(other.floorToGo, this.floorToGo);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "floorToGo=" + floorToGo +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                '}';
    }
}
