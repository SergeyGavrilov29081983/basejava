package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Resume resume, String key) {
        map.put((String) key, resume);
    }

    @Override
    protected void updateElement(Resume resume, String key) {
        map.put(key, resume);
    }

    @Override
    protected Resume getElement(String key) {
        return map.get(key);
    }

    @Override
    protected void deleteElement(String key) {
        map.remove(key);
    }

    @Override
    protected boolean isExist(String key) {
        return map.containsKey(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected List<Resume> getStorage () {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected String getKey(String uuid) {
        return uuid;
    }
}
