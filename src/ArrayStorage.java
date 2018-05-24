import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private int position = 0;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            if (isElement(resume)) {
                System.out.println("Такое резюме уже есть в базе " + resume);
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("база резюме полная!!!");
        }
    }

    public void update(Resume resume) {
        if (isElement(resume)) {
            storage[position] = resume;
        } else {
            System.out.println("Резюме отсутствует " + resume);
        }
    }

    public Resume get(Resume resume) {
        if (isElement(resume)) {
            return storage[position];
        } else {
            System.out.println("Резюме отсутствует " + resume);
            return null;
        }
    }

    public void delete(Resume resume) {
        if (isElement(resume)) {
            size--;
            storage[position] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Резюме отсутствует " + resume);
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean isElement(Resume resume) {
        for (int i = 0; i <= size; i++) {
            if (resume.equals(storage[i])) {
                position = i;
                return true;
            }
        }
        return false;
    }
}
