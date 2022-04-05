package domain.model;

import domain.model.request.CreateBuildingRequest;

import java.util.List;
import java.util.Queue;

public class Building {

    public static final int GROUND_FLOOR = 1;

    private int floors;
    private Elevator elevator;
    private List<Queue<Passenger>> floorsWithPassengers;

    public Building(int floors, List<Queue<Passenger>> floorsWithPassengers) {
        this.floors = floors;
        this.floorsWithPassengers = floorsWithPassengers;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public List<Queue<Passenger>> getFloorsWithPassengers() {
        return floorsWithPassengers;
    }

    public void setFloorsWithPassengers(List<Queue<Passenger>> floorsWithPassengers) {
        this.floorsWithPassengers = floorsWithPassengers;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public String toString() {
        return "Building{" +
                "floors=" + floors +
                ", elevator=" + elevator +
                ", floorsWithPassengers=" + floorsWithPassengers +
                '}';
    }
}
