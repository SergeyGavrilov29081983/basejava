package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

import java.util.*;


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

    private Object getKeyIfResumeExist(String uuid) {
        Object key = getKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getKeyIfResumeNotExist(String uuid) {
        Object key = getKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getStorage();
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    protected abstract Object getKey(String uuid);

    protected abstract void saveElement(Resume resume, Object key);

    protected abstract void updateElement(Resume resume, Object key);

    protected abstract Resume getElement(Object key);

    protected abstract void deleteElement(Object key);

    protected abstract boolean isExist(Object key);

    protected abstract List<Resume> getStorage();
}




