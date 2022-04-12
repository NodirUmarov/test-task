package domain.dao.impl;

import domain.dao.ElevatorDao;
import domain.model.Building;
import domain.model.Elevator;
import domain.model.Floor;
import domain.model.builder.BuildingBuilder;
import domain.model.builder.ElevatorBuilder;
import domain.model.builder.FloorBuilder;
import domain.model.enums.Direction;

import java.sql.*;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class ElevatorDaoImpl implements ElevatorDao {

    public ElevatorDaoImpl() { Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            String createTable = "" +
                    "CREATE TABLE IF NOT EXISTS tb_elevators(" +
                    "id               BIGSERIAL, " +
                    "building_name    VARCHAR(50) NOT NULL, " +
                    "capacity         INTEGER      NOT NULL, " +
                    "current_floor_id BIGINT       NOT NULL, " +
                    "floor_to_go_id   BIGINT       NOT NULL, " +
                    "direction        CHAR(4)      NOT NULL DEFAULT 'UP', " +
                    "" +
                    "CONSTRAINT pk_elevator_id PRIMARY KEY (id), " +
                    "CONSTRAINT chk_id_positive CHECK (id > 0), " +
                    "CONSTRAINT fk_building_name FOREIGN KEY (building_name) " +
                    "   REFERENCES tb_buildings(name), " +
                    "CONSTRAINT fk_current_floor_id FOREIGN KEY (current_floor_id) " +
                    "   REFERENCES tb_floors(id), " +
                    "CONSTRAINT fk_floor_to_go_id FOREIGN KEY (floor_to_go_id) " +
                    "   REFERENCES tb_floors(id), " +
                    "CONSTRAINT one_to_one_relation UNIQUE (building_name)" +
                    ");";

            statement.execute(createTable);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }


    @Override
    public <SubModel extends Elevator> SubModel save(SubModel elevator) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String insertQuery = "" +
                    "INSERT INTO tb_elevators(building_name, capacity, current_floor_id, floor_to_go_id) " +
                    "VALUES (?, ?, ?, ?) RETURNING id";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, elevator.getBuilding().getName());
            preparedStatement.setInt(2, elevator.getCapacity());
            preparedStatement.setLong(3, elevator.getCurrentFloor().getId());
            preparedStatement.setLong(4, elevator.getFloorToGo().getId());

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            elevator.setId(resultSet.getLong(1));

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(resultSet);
        }

        return elevator;
    }

    @Override
    public Optional<Elevator> findById(String s) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String elevatorSelect = "SELECT * FROM tb_elevators e WHERE e.building_name IN (?);";

            preparedStatement = connection.prepareStatement(elevatorSelect);
            preparedStatement.setString(1, s);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Elevator elevator = ElevatorBuilder
                    .builder()
                    .id(resultSet.getLong(1))
                    .capacity(resultSet.getInt(2))
                    .direction(Direction.valueOf(resultSet.getString(6)))
                    .build();

            Long currentFloor = resultSet.getLong(3);
            Long floorToGo = resultSet.getLong(4);

            close(preparedStatement);
            close(resultSet);

            String buildingSelect = "SELECT * FROM tb_buildings WHERE name IN (?);";

            preparedStatement = connection.prepareStatement(buildingSelect);
            preparedStatement.setString(1, s);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Building building = BuildingBuilder
                    .builder()
                    .name(resultSet.getString("name"))
                    .topFloor(resultSet.getInt("top_floor"))
                    .elevator(elevator)
                    .build();

            close(preparedStatement);
            close(resultSet);

            String floorsSelect = "SELECT * FROM tb_floors WHERE building_name IN (?) ORDER BY floor_number";

            preparedStatement = connection.prepareStatement(floorsSelect);
            preparedStatement.setString(1, s);

            resultSet = preparedStatement.executeQuery();
            Queue<Floor> floors = new LinkedList<>();

            while (resultSet.next()) {
                PreparedStatement innerPrepared = connection.prepareStatement();
                Floor floor = FloorBuilder
                        .builder()
                        .id(resultSet.getLong(1))
                        .floorNumber(resultSet.getInt(2))
                        .building(building)
                        .build();
                floors.add(floor);
            }


            building.setFloorsWithPassengers(floors);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return Optional.empty();
    }
}
