package domain.dao.impl;

import domain.dao.BuildingDao;
import domain.model.Building;

import java.sql.*;
import java.util.Optional;

public class BuildingDaoImpl implements BuildingDao {

    public BuildingDaoImpl() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            String createTable = "" +
                    "CREATE TABLE IF NOT EXISTS tb_buildings(" +
                    "name        VARCHAR(50) NOT NULL, " +
                    "top_floor   SMALLINT    NOT NULL, " +
                    "" +
                    "CONSTRAINT pk_building_id PRIMARY KEY (name)" +
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
    public <SubModel extends Building> SubModel save(SubModel building) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            String insertQuery = "" +
                    "INSERT INTO tb_buildings(name, top_floor) " +
                    "VALUES (?, ?) ";

            preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, building.getName());
            preparedStatement.setLong(2, building.getTopFloor());

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(resultSet);
        }
        return building;
    }

    @Override
    public Optional<Building> findById(String name) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = getConnection();
//
//            String selectQuery = "" +
//                    "SELECT b.* " +
//                    "FROM tb_buildings AS b " +
//                    "JOIN tb_floors AS f " +
//                    "ON b.name";
//
//            preparedStatement = connection.prepareStatement(selectQuery);
//            preparedStatement.setLong(1, id);
//            resultSet = preparedStatement.executeQuery();
//
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        } finally {
//            close(resultSet);
//            close(preparedStatement);
//            close(connection);
//        }
        return Optional.empty();
    }
}
