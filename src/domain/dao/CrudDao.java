package domain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public interface CrudDao<Model, ID> {

    <SubModel extends Model> SubModel save(SubModel model);
    Optional<Model> findById(ID id);

    default Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://ec2-34-197-182-7.compute-1.amazonaws.com:5432/d1ca75urdgfd01";
        String username = "pcwuvtaysgmwqv";
        String password = "38476e1c91aebce732f225b6dbfe69e19900bc2ce5e8eb6ab7e07875c2559e66";

        return DriverManager.getConnection(url, username, password);
    }

    default void close(AutoCloseable closeable) {
        try {
            closeable.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
