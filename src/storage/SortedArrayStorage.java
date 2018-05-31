package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(resume.getUuid()) != -1) {
                System.out.println("Резюме  с uuid = " + resume.getUuid() + " уже существует");
            } else {
                storage[size] = resume;
                size++;
                Arrays.sort(storage,0,size);
            }
        } else {
            System.out.println("Хранилище заполнено");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            System.arraycopy(storage, index + 1, storage, index, size);
            size--;
        } else {
            System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int index = Arrays.binarySearch(storage, 0, size, searchKey);
        if (index >= 0) {
            return index;
        }
        return -1;
    }
}
