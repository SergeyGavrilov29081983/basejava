package storage;

import exceptions.ExistStorageException;
import exceptions.StorageException;
import org.postgresql.util.PSQLException;
import sql.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            if(e instanceof PSQLException) {
                if (e.getSQLState().equals("23505")) {
                    throw new ExistStorageException("resume already exist");
                }
            }
            throw new StorageException(e);
        }
    }
}
