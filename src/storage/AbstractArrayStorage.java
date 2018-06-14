package storage;

import exceptions.ExistStorageException;
import exceptions.StorageException;
import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index < 0) {
                saveElement(resume);
                size++;
            } else {
                throw new ExistStorageException(resume.getUuid());
            }
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public void delete(String uuid) {
        size--;
        deleteElement(uuid, getResume(uuid));
        storage[size] = null;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public int size() {
        return size;
    }

    protected void updateElement(Resume resume, String uuid, Integer index) {
        storage[index] = resume;
    }

    protected Resume getElement(String uuid, Integer index) {
        return storage[index];
    }
}
