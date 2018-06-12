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
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected void updateElement(Resume resume, int index, String uuid) {
        storage.set(index, resume);
    }

    @Override
    protected Resume getElement(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected void deleteElement(int index, String uuid) {
        storage.remove(index);
    }

    @Override
    protected Resume[] getAllElements() {
        storage.trimToSize();
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected int storageSize() {
        return storage.size();
    }

    @Override
    protected void saveElement(Resume resume, int index, String uuid) {
        storage.add(resume);
    }
}
