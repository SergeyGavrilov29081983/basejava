package storage;

import model.Resume;

import java.util.*;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() { storage.clear();
    }

    @Override
    protected void saveElement(Resume resume, Integer index) {
        storage.add(resume);
    }

    @Override
    protected void updateElement(Resume resume, Integer index) {
        storage.set(index, resume);
    }

    @Override
    protected Resume getElement(Integer key) {
        return storage.get(key);
    }

    @Override
    protected void deleteElement(Integer key) {
        storage.remove((int)key);
    }

    @Override
    protected boolean isExist(Integer key) {
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