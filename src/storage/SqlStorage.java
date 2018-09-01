package storage;

import exceptions.NotExistStorageException;
import model.Resume;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlStorage implements Storage {

    private final SqlHelper sqlHelper;

    public SqlStorage(SqlHelper sqlHelper) {
        this.sqlHelper = sqlHelper;
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume", preparedStatement -> {
            preparedStatement.execute();
            return null;
        });
    }

    @Override
    public void save(Resume resume) throws Exception {
        sqlHelper.execute("INSERT INTO resume (uuid, full_name) VALUES (?,?)",
                preparedStatement -> {
                    preparedStatement.setString(1, resume.getUuid());
                    preparedStatement.setString(2, resume.getFullName());
                    preparedStatement.execute();
                    return null;
                });
    }

    @Override
    public void update(Resume resume) throws Exception {
        sqlHelper.execute("UPDATE resume SET full_name=? WHERE uuid=?", preparedStatement -> {
            preparedStatement.setString(1, resume.getFullName());
            preparedStatement.setString(2, resume.getUuid());
            preparedStatement.execute();
            return null;
        });
    }

    @Override
    public Resume get(String uuid) throws Exception {
        return sqlHelper.execute("SELECT * FROM resume r WHERE r.uuid =?", preparedStatement -> {
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageException(uuid);
            }
            return new Resume(uuid, rs.getString("full_name"));
        });
    }

    @Override
    public void delete(String uuid) throws Exception {
        sqlHelper.execute("DELETE  FROM resume WHERE (uuid=?)", preparedStatement -> {
            preparedStatement.setString(1, uuid);
            preparedStatement.executeUpdate();
            return null;

        });
        get(uuid);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>();
        return sqlHelper.execute("SELECT * FROM resume", preparedStatement -> {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Resume(resultSet.getString("uuid").trim(), resultSet.getString("full_name")));
            }
            return list;
        });
    }

    @Override
    public int size() {
        final int[] count = {0};
        sqlHelper.execute("SELECT * FROM resume", preparedStatement -> {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count[0]++;
            }
            return null;
        });
        return count[0];
    }
}




