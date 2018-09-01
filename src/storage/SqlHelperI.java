package storage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SqlHelperI<T> {
    T execute(PreparedStatement preparedStatement) throws SQLException;
}
