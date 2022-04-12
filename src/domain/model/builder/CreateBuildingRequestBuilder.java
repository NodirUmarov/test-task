package domain.model.builder;

import domain.model.request.CreateBuildingRequest;

public class CreateBuildingRequestBuilder {

    private String name;
    private Integer topFloor;
    private Integer elevators;
    private Integer elevatorCapacity;

    private CreateBuildingRequestBuilder() {
    }

    public static CreateBuildingRequestBuilder builder() {
        return new CreateBuildingRequestBuilder();
    }

    public CreateBuildingRequest build() {
        return new CreateBuildingRequest(name, topFloor, elevators, elevatorCapacity);
    }

    public CreateBuildingRequestBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CreateBuildingRequestBuilder topFloor(Integer topFloor) {
        this.topFloor = topFloor;
        return this;
    }

    public CreateBuildingRequestBuilder elevators(Integer elevators) {
        this.elevators = elevators;
        return this;
    }

    public CreateBuildingRequestBuilder elevatorCapacity(Integer elevatorCapacity) {
        this.elevatorCapacity = elevatorCapacity;
        return this;
    }
}
