package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public final void save(Resume resume) {
        saveElement(resume, getKeyIfResumeNotExist(resume.getUuid()));
    }

    @Override
    public final void update(Resume resume) {
        updateElement(resume, getKeyIfResumeExist(resume.getUuid()));
    }

    @Override
    public final Resume get(String uuid) {
        return getElement(getKeyIfResumeExist(uuid));
    }

    @Override
    public final void delete(String uuid) {
        deleteElement(getKeyIfResumeExist(uuid));
    }

    private int getKeyIfResumeExist(String uuid) {
        int key = getKey(uuid);
        if (key < 0) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private  int getKeyIfResumeNotExist(String uuid) {
        int key = getKey(uuid);
        if (key >= 0) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract int getKey(String uuid);

    protected abstract void saveElement(Resume resume, Object key);

    protected abstract void updateElement(Resume resume, Object key);

    protected abstract Resume getElement(Object key);

    protected abstract void deleteElement(Object key);
}




