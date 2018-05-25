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
            if (getIndex(resume.uuid) != -1) {
                System.out.println("Резюме  с uuid = " + resume.getUuid() + " уже существует");
            } else {
                storage[size] = resume;
                size++;
            }
        } else {
            System.out.println("база резюме полная!!!");
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.uuid) != -1) {
            storage[getIndex(resume.uuid)] = resume;
        } else {
            System.out.println("Резюме  с uuid = " + resume.getUuid() + " отсутствует");
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            return storage[getIndex(uuid)];
        } else {
            System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
            return null;
        }
    }

    public void delete(String uuid) {
        if (getIndex(uuid) != -1) {
            size--;
            storage[getIndex(uuid)] = storage[size];
            storage[size] = null;
        } else {
            System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
            for (int i = 0; i <= size; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    return i;
                }
            }
        return -1;
    }
}
