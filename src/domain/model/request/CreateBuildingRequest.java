package domain.model.request;

public class CreateBuildingRequest {

    private String name;
    private Integer topFloor;
    private Integer elevators;
    private Integer elevatorCapacity;

    public CreateBuildingRequest(String name, Integer topFloor, Integer elevators, Integer elevatorCapacity) {
        this.name = name;
        this.topFloor = topFloor;
        this.elevators = elevators;
        this.elevatorCapacity = elevatorCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(Integer topFloor) {
        this.topFloor = topFloor;
    }

    public Integer getElevators() {
        return elevators;
    }

    public void setElevators(Integer elevators) {
        this.elevators = elevators;
    }

    public Integer getElevatorCapacity() {
        return elevatorCapacity;
    }

    public void setElevatorCapacity(Integer elevatorCapacity) {
        this.elevatorCapacity = elevatorCapacity;
    }

    @Override
    public String toString() {
        return "CreateBuildingRequest{" +
                "name='" + name + '\'' +
                ", topFloor=" + topFloor +
                ", elevators=" + elevators +
                ", elevatorCapacity=" + elevatorCapacity +
                '}';
    }
}
