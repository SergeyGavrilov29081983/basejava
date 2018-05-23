import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            if (Arrays.asList(storage).contains(r)) {
                System.out.println("Такое резюме уже есть в базе " + r);
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("база резюме полная!!!");
        }
    }


    public void update(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i])) {
                storage[i].uuid = uuid;
                break;
            } else {
                System.out.println("Резюме отсутствует");
                break;
            }
        }
    }


    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return storage[i];
            }
        }
        System.out.println("Резюме отсутствует");
        return null;
    }

    public void delete(String uuid) {
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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
