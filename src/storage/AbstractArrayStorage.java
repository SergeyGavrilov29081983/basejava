package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
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
            if (index >= 0) {
                generateException(index, resume.getUuid());
            } else {
                doSave(resume, index);
                size++;
            }
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            generateException(index, resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            generateException(index, uuid);
        }
        return storage[index];
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            size--;
            doDelete(index);
            storage[size] = null;
        } else {
            generateException(index, uuid);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void doSave(Resume resume, int index);

    protected abstract void doDelete(int index);
}
