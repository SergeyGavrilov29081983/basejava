package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        saveElement(resume, getKeyIfResumeNotExist(resume.getUuid()));
    }

    @Override
    public final void update(Resume resume) {
        updateElement(resume, getKeyIfResumeExist(resume.getUuid()));
    }

    @Override
    public final Resume get(String uuid) {
        return getElement(uuid, getKeyIfResumeExist(uuid));
    }

    @Override
    public void delete(String uuid) {
        deleteElement((uuid), getKeyIfResumeExist(uuid));
    }

    protected final int getKeyIfResumeExist(String uuid) {
        int index = getKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    protected final int getKeyIfResumeNotExist(String uuid) {
        int index = getKey(uuid);
        if (index >= 0) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }

    protected abstract int getKey(String uuid);

    protected abstract void saveElement(Resume resume, Integer index);

    protected abstract void updateElement(Resume resume, Integer index);

    protected abstract Resume getElement(String uuid, Integer index);

    protected abstract void deleteElement(String uuid, Integer index);
}




