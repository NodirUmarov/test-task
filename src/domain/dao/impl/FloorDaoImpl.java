package domain.dao.impl;

import domain.dao.FloorDao;
import domain.model.Floor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class FloorDaoImpl implements FloorDao {

    public FloorDaoImpl() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = getConnection();
            statement = connection.createStatement();

            String createTable = "" +
                    "CREATE TABLE IF NOT EXISTS tb_floors(" +
                    "id            BIGSERIAL, " +
                    "building_name VARCHAR(50) NOT NULL, " +
                    "floor_number  BIGINT      NOT NULL, " +
                    "" +
                    "CONSTRAINT pk_floor_id PRIMARY KEY (id), " +
                    "CONSTRAINT fk_building_name FOREIGN KEY (building_name) " +
                    "   REFERENCES tb_buildings(name), " +
                    "CONSTRAINT chk_id_positive CHECK (id > 0)" +
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
    public <SubModel extends Floor> SubModel save(SubModel floor) {
        return null;
    }

    @Override
    public Optional<Floor> findById(Long aLong) {
        return Optional.empty();
    }
}
