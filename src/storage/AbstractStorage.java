package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            saveElement(resume);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void update(Resume resume) {
        updateElement(resume, resume.getUuid());
        }

    @Override
    public Resume get(String uuid) {
        return getElement(uuid);
    }

    @Override
    public void delete(String uuid) {
        deleteElement(uuid);
    }

    protected int getResume(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveElement(Resume resume);

    protected abstract void updateElement(Resume resume, String uuid);

    protected abstract Resume getElement(String uuid);

    protected abstract void deleteElement(String uuid);
}




