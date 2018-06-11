package storage;

import model.Resume;

public interface Storage {

    void clear();

    void save(Resume resume) throws Exception;

    void update(Resume resume) throws Exception;

    Resume get(String uuid) throws Exception;

    void delete(String uuid) throws Exception;

    Resume[] getAll();

    int size();
}
