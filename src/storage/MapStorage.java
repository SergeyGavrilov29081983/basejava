package storage;

import model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Resume resume, Resume key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Resume resume, Resume key) {
        map.put(resume.getUuid(), key);
    }

    @Override
    protected Resume getElement(Resume key) {
        return key;
    }

    @Override
    protected void deleteElement(Resume key) {
        map.remove(key.getUuid());
    }

    @Override
    protected boolean isExist(Resume key) {
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
    protected Resume getKey(String uuid) {
        return map.get(uuid);
    }
}
