package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index < 0) {
                saveElement(resume, index, null);
                size++;
            } else {
                generateException(index, null);
            }
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            generateException(index, uuid);
        } else {
            size--;
            deleteElement(index, null);
            storage[size] = null;
        }
    }

    @Override
    protected void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void updateElement(Resume resume, int index, String uuid) {
        storage[index] = resume;
    }

    protected Resume getElement(int index, String uuid) {
        return storage[index];
    }

    @Override
    protected Resume[] getAllElements() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected int storageSize() {
        return size;
    }
}
