package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public List<Resume> getAllSorted() {
        storage.sort(Comparator.comparing(Resume::getUuid));
        return storage;
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
