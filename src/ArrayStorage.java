
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    private int size;


    void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
            } else {
                storage[i] = r;
                size += 1;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (storage[i].uuid == uuid) {
                break;
            }
        }
        System.arraycopy(storage, i + 1, storage, i, storage.length - 1 - i);
        size -= 1;
    }

    Resume[] getAll() {
        Resume[] resume = new Resume[size];
        System.arraycopy(storage, 0, resume, 0, size);
        return resume;
    }

    int size() {
        return size;
    }

}
