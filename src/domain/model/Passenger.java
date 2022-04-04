package domain.model;

public class Passenger implements Comparable<Passenger> {

    private int floorToGo;
    private int currentFloor;

    public Passenger(int currentFloor, int floorToGo) {
        this.currentFloor = currentFloor;
        this.floorToGo = floorToGo;
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
        return Integer.compare(other.floorToGo, this.floorToGo);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "floorToGo=" + floorToGo +
                ", currentFloor=" + currentFloor +
                '}';
    }
}
