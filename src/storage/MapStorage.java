package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;


public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }


    @Override
    protected void saveElement(Resume resume) {
    }

    @Override
    protected void updateElement(Resume resume, String uuid, Integer index) {

    }

    @Override
    protected Resume getElement (String uuid, Integer index) {
        return null;
    }

    @Override
    protected void deleteElement(String uuid, Integer index) {
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
