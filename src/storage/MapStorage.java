package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected int getKey(String uuid) {
        return 0;
    }


    @Override
    protected void saveElement(Resume resume, Integer key) {
    }

    @Override
    protected void updateElement(Resume resume, Integer key) {

    }

    @Override
    protected Resume getElement(String uuid, Integer key) {
        return null;
    }

    @Override
    protected void deleteElement(String uuid, Integer key) {
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
