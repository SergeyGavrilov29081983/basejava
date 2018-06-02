package storage;

import model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index >= 0) {
                System.out.println("Резюме  с uuid = " + resume.getUuid() + " уже существует");
            } else {
                doSave(resume);
                size++;
            }
        } else {
            System.out.println("Хранилище заполнено");
        }
    }

    protected abstract void doSave(Resume resume);

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме  с uuid = " + resume.getUuid() + " отсутствует");
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
        return null;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            doDelete(index);
            size--;
        } else {
            System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
        }
    }

    protected abstract void doDelete(int index);

    @Override
    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
}
