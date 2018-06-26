package storage;

import model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Resume resume, Object key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        map.put(resume.getUuid(), (Resume) key);
    }

    @Override
    protected Resume getElement(Object key) {
        return (Resume) key;
    }

    @Override
    protected void deleteElement(Object key) {
        map.remove(((Resume) key).getUuid());
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
    protected List<Resume> getStorage() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getKey(String uuid) {
        return map.get(uuid);
    }
}
