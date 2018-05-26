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
            System.out.println("Хранилище заполнено");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.uuid);
        if (index != -1) {
            storage[index] = resume;
            System.out.println("update");
        } else {
            System.out.println("Резюме  с uuid = " + resume.uuid + " отсутствует");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
            System.out.println("Резюме  с uuid = " + uuid + " отсутствует");
            return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            size--;
            storage[index] = storage[size];
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
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }
}
