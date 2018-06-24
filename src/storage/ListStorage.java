package storage;

import model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveElement(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected void updateElement(Resume resume, Object index) {
        storage.set((int)index, resume);
    }

    @Override
    protected Resume getElement(Object key) {
        return storage.get((int)key);
    }

    @Override
    protected void deleteElement(Object key) {
        storage.remove((int) key);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected List<Resume> getStorage() {
        return new ArrayList<>(storage);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Integer getKey(String uuid) {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).getUuid().equals(uuid)) {
                    return i;
                }
            }
            return null;
    }
}
