package storage;

import model.Resume;
import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private final ArrayList<Resume> storage = new ArrayList<>();

    protected int getIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return storage.indexOf(resume);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveElement(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void updateElement(Resume resume, String uuid, Integer index) {
        storage.set(index, resume);
    }

    @Override
    protected Resume getElement(String uuid, Integer index) {
        return storage.get(index);
    }

    @Override
    protected void deleteElement(String uuid, Integer index) {
        storage.remove(index);
    }

    @Override
    public Resume[] getAll() {
        storage.trimToSize();
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
