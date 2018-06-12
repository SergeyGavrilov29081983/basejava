package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void clear() {
        clearStorage();
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            saveElement(resume, index, null);
        } else {
            generateException(index, resume.getUuid());
        }
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            generateException(index, resume.getUuid());
        } else {
            updateElement(resume, index, null);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            generateException(index, uuid);
        }
        return getElement(index, null);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            generateException(index, uuid);
        } else {
            deleteElement(index, null);
        }
    }

    public Resume[] getAll() {
        return getAllElements();
    }

    @Override
    public int size() {
        return storageSize();
    }

    protected void generateException(int index, String uuid) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract void clearStorage();

    protected abstract void saveElement(Resume resume, int index, String uuid);

    protected abstract void updateElement(Resume resume, int index, String uuid);

    protected abstract Resume getElement(int index, String uuid);

    protected abstract void deleteElement(int index, String uuid);

    protected abstract Resume[] getAllElements();

    protected abstract int storageSize();
}




