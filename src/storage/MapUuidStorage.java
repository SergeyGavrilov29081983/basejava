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
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            Object searchKey = entry.getKey();
            if (searchKey.equals(key)) {
                return map.get(searchKey);
            }
        }
        return null;
    }

    @Override
    protected void deleteElement(Object key) {
        String searchKey = (String) key;
        map.remove(searchKey);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        Collection<Resume> list = map.values();
        List<Resume> storage = new ArrayList<>(list);
        storage.sort(Comparator.comparing(Resume::getUuid));
        return storage;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getKey(String uuid) {
        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key.equals(uuid)) {
                return key;
            }
        }
        return null;
    }
}
