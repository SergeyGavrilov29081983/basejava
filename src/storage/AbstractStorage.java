package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage {

    ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume resume) throws Exception {
        int index = getIndex(resume.getUuid());
        if (index >= 0){
            generateException(index, resume.getUuid());
        } else {
            storage.add(resume);
        }
    }

    @Override
    public void update(Resume resume) throws Exception {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage.set(index, new Resume(resume.getUuid()));
        } else {
            generateException(index, resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) throws Exception {
        int index = getIndex(uuid);
        if (index < 0) {
            generateException(index, uuid);
        }
        return storage.get(index);
    }

    @Override
    public void delete(String uuid) throws Exception {
        int index = getIndex(uuid);
        Resume resume = new Resume(uuid);
        if (index >= 0) {
            storage.remove(resume);
        } else {
           generateException(index, uuid);
        }
    }


    public Resume[] getAll() {
        storage.trimToSize();
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
    protected void generateException(int index, String uuid) {
        if (index < 0){
            throw new NotExistStorageException(uuid);
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract int getIndex(String uuid);
}




