package domain.dao.impl;

import domain.dao.PassengerDao;
import domain.model.Passenger;

import java.sql.*;
import java.util.Optional;

public class PassengerDaoImpl implements PassengerDao {

    public PassengerDaoImpl() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            String createTable = "" +
                    "CREATE TABLE IF NOT EXISTS tb_passengers(" +
                    "id            BIGSERIAL, " +
                    "name          VARCHAR(50) NOT NULL, " +
                    "floor_to_go   BIGINT      NOT NULL, " +
                    "direction     CHAR(4)     NOT NULL, " +
                    "current_floor BIGINT      NOT NULL, " +
                    "" +
                    "CONSTRAINT pk_passenger_id PRIMARY KEY (id), " +
                    "CONSTRAINT chk_id_positive CHECK (id > 0), " +
                    "CONSTRAINT fk_floor_to_go_id FOREIGN KEY (floor_to_go) " +
                    "   REFERENCES tb_floors(id), " +
                    "CONSTRAINT fk_current_floor_id FOREIGN KEY (current_floor) " +
                    "   REFERENCES tb_floors(id)" +
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
    public <SubModel extends Passenger> SubModel save(SubModel passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String insertQuery = "" +
                    "INSERT INTO tb_passengers(name, floor_to_go, direction, current_floor) " +
                    "VALUES (?, ?, ?, ?) " +
                    "RETURNING id;";

            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setLong(2, passenger.getFloorToGo().getId());
            preparedStatement.setString(3, passenger.getDirection().name());
            preparedStatement.setLong(4, passenger.getCurrentFloor().getId());

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            passenger.setId(resultSet.getLong(1));

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(resultSet);
        }
        return passenger;
    }

    @Override
    public Optional<Passenger> findById(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String selectQuery = "" +
                    "SELECT p.id, p.name, p.floor_to_go, p.direction, p.current_floor, fg.id, fg.floor_number FROM tb_passengers p " +
                    "JOIN tb_floors fg " +
                    "ON p.floor_to_go = fg.id " +
                    "JOIN tb_floors ft " +
                    "ON p.current_floor = fg.id " +
                    "WHERE id = ?";

            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();


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
