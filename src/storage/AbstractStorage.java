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
        updateElement(resume, resume.getUuid(), getResume(resume.getUuid()));
        }

    @Override
    public Resume get(String uuid) {
        return getElement(uuid, getResume(uuid));
    }

    @Override
    public void delete(String uuid) {
        deleteElement((uuid), getResume(uuid));
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

    protected abstract void updateElement(Resume resume, String uuid, Integer index);

    protected abstract Resume getElement(String uuid, Integer index);

    protected abstract void deleteElement(String uuid, Integer index);
}




