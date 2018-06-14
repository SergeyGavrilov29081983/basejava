package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void saveElement(Resume resume, Integer index) {
        if (size < STORAGE_LIMIT) {
            insertResume(resume, getKeyIfResumeNotExist(resume.getUuid()));
            size++;
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public final void deleteElement(String uuid, Integer index) {
        size--;
        deleteResume(uuid, getKeyIfResumeExist(uuid));
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

    protected final void updateElement(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    protected final Resume getElement(String uuid, Integer index) {
        return storage[index];
    }

    protected abstract void insertResume(Resume resume, Integer index);

    protected abstract void deleteResume(String uuid, Integer index);
}
