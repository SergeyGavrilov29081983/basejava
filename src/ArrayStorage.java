
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                continue;
            } else {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        String searchKey = uuid;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].uuid == searchKey) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        String searchKey = uuid;
        int i = 0;
        int count = storage.length;

        for (i = 0; i < count; i++) {
            if (storage[i].uuid == searchKey) {
                break;
            }
        }
        for (int k = i; k < count - 1; k++)
            storage[k] = storage[k + 1];
        count--;

    }

    Resume[] getAll() {
        Resume[] resume = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            if (storage[i] != null) {
                resume[i] = storage[i];
            } else break;
        }
        return resume;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }
}
