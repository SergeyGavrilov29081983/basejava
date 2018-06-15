package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    private static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void saveElement(Resume resume, Integer key) {
        if (size < STORAGE_LIMIT) {
            insertResume(resume, key);
            size++;
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public final void deleteElement(Integer key) {
        size--;
        deleteResume(key);
        storage[size] = null;
    }

    @Override
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public final int size() {
        return size;
    }

    protected final void updateElement(Resume resume, Integer key) {
        storage[key] = resume;
    }

    @Override
    protected final Resume getElement(Integer key) {
        return storage[key];
    }

    protected abstract void insertResume(Resume resume, Integer key);

    protected abstract void deleteResume(Integer key);
}
