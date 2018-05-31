package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(resume.getUuid()) != -1) {
                System.out.println("Резюме  с uuid = " + resume.getUuid() + " уже существует");
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("Хранилище заполнено");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме  с uuid = " + resume.getUuid() + " отсутствует");
        }
    }

    public abstract void delete(String uuid);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
}
