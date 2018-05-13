
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int size = storage.length;


    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null) {
            } else {
                storage[i] = r;
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
        for (i = 0; i < size(); i++) {
            if (storage[i].uuid == uuid) {
                break;
            }
        }
        System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
    }

    Resume[] getAll() {
        Resume[] resume = new Resume[size()];
        System.arraycopy(storage, 0, resume, 0, size());
        return resume;
    }

    int size() {
        int count = 0;
        for (Resume aStorage : storage) {
            if (aStorage != null) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }
}
