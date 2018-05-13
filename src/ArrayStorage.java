
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
        for (int i = size; size < storage.length; i++) {
                storage[i] = r;
                size++;
                break;
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
        size--;
    }

    Resume[] getAll() {
        Resume[] storage1 = new Resume[size];
        System.arraycopy(storage, 0, storage1, 0, size);
        return storage1;
    }

    int size() {
        return size;
    }

}
