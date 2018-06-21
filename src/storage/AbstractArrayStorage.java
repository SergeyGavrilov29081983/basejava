package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.*;

public abstract class AbstractArrayStorage extends AbstractStorage {

    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void saveElement(Resume resume, Object index) {
        if (size < STORAGE_LIMIT) {
            insertResume(resume, (int)index);
            size++;
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public final void deleteElement(Object index) {
        size--;
        deleteResume((int)index);
        storage[size] = null;
    }

    @Override
    public final List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(Arrays.asList(storage));
        List<Resume> sortedList = new ArrayList<>();
        for (Resume r: list
             ) {
            if (r != null){
                sortedList.add(r);
            }
        }
        sortedList.sort(Comparator.comparing(Resume::getUuid));
        return  sortedList;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    @Override
    public final int size() {
        return size;
    }

    protected final void updateElement(Resume resume, Object index) {
        storage[(int)index] = resume;
    }

    @Override
    protected final Resume getElement(Object index) {
        return storage[(int)index];
    }

    protected abstract void insertResume(Resume resume, Integer index);

    protected abstract void deleteResume(Integer index);
}
