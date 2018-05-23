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
            if (isElement(r)) {
                System.out.println("Такое резюме уже есть в базе " + r);
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("база резюме полная!!!");
        }
    }

    public void update(Resume r) {
        if (isElement(r)) {
            storage[getElement(r)] = r;
        } else {
            System.out.println("Резюме отсутствует");
        }
    }

    public Resume get(Resume r) {
        if (isElement(r)) {
            return storage[getElement(r)];
        } else {
            System.out.println("Резюме отсутствует");
            return null;
        }
    }

    public void delete(Resume r) {
        if (isElement(r)) {
            storage[getElement(r)] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме отсутствует");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean isElement(Resume r) {
        for (int i = 0; i <= size; i++) {
            if (r.equals(storage[i])) {
                return true;
            }
        }
        return false;
    }

    private int getElement(Resume r) {
        for (int i = 0; i <= size; i++) {
            if (r.equals(storage[i])) {
                return i;
            }
        }
        return 0;
    }
}
