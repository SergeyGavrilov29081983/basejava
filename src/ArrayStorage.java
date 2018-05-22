/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            for (int i = 0; i <= size; i++) {
                if (r.equals(storage[i])) {
                    System.out.println("!");
                    break;
                } else {
                    storage[size] = r;
                    size++;
                    break;
                }

            }
        }
    }

    void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.equals(storage[i])) {
                storage[i] = r;
            } else {
                System.out.println("Резюме отсутствует");
                break;
            }
        }
    }


    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }

        }
        System.out.println("Резюме отсутствует");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            } else {
                System.out.println("Резюме отсутствует");
                break;
            }
        }
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
