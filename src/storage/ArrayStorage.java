package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertResume(Resume resume, Integer index) {
        storage[size] = resume;
    }

    @Override
    protected void deleteResume(Integer index) {
        storage[index] = storage[size];
    }

    @Override
    protected Integer getKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}