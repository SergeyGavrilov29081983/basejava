package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Resume resume, Object key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object key) {
        return map.get(key);
    }

    @Override
    protected void deleteElement(Object key) {
        String searchKey = (String) key;
        map.remove(searchKey);
    }

    @Override
    protected boolean isExist(Object key) {
        return map.containsKey((String) key);
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
    protected Object getKey(String uuid) {
        return uuid;
    }
}
