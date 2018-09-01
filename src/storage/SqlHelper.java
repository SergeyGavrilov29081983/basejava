package storage;

import exceptions.StorageException;
import sql.ConnectionFactory;

import java.sql.*;

public class SqlHelper {

    private final ConnectionFactory connectionFactory;

    public SqlHelper(String dbUrl, String dbUser, String dbPassword) {
        this.connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);

    }

    public <T> T execute(String sql, SqlHelperI<T> sqlHelperI) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return sqlHelperI.execute(ps);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
