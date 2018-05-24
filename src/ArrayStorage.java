import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length) {
            if (resume.equals(storage[getIndex(resume)])) {
                System.out.println("Резюме  с uuid = " + resume + " уже существует");
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("база резюме полная!!!");
        }
    }

    public void update(Resume resume) {
        if (resume.equals(storage[getIndex(resume)])) {
            storage[getIndex(resume)] = resume;
        } else {
            System.out.println("Резюме  с uuid = " + resume + " отсутствует");
        }
    }

    public Resume get(Resume resume) {
        if (resume.equals(storage[getIndex(resume)])) {
            return storage[getIndex(resume)];
        } else {
            System.out.println("Резюме  с uuid = " + resume + " отсутствует");
            return null;
        }
    }

    public void delete(Resume resume) {
        if (resume.equals(storage[getIndex(resume)])) {
            size--;
            storage[getIndex(resume)] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Резюме  с uuid = " + resume + " отсутствует");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(Resume resume) {
        for (int i = 0; i <= size; i++) {
            if (resume.equals(storage[i])) {

                return i;
            }
        }
        return 0;
    }
}
