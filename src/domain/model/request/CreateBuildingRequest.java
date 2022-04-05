package domain.model.request;

public class CreateBuildingRequest {
    private int floorsNumber;
    private int elevatorMaxCapacity;

    public CreateBuildingRequest(int floorsNumber, int elevatorMaxCapacity) {
        this.floorsNumber = floorsNumber;
        this.elevatorMaxCapacity = elevatorMaxCapacity;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public int getElevatorMaxCapacity() {
        return elevatorMaxCapacity;
    }

    public void setElevatorMaxCapacity(int elevatorMaxCapacity) {
        this.elevatorMaxCapacity = elevatorMaxCapacity;
    }

    @Override
    public String toString() {
        return "CreateBuildingRequest{" +
                "floorsNumber=" + floorsNumber +
                ", elevatorMaxCapacity=" + elevatorMaxCapacity +
                '}';
    }
}
