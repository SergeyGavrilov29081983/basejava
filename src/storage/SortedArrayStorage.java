package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(new Function<Resume, String>() {
        @Override
        public String apply(Resume resume) {
            return resume.getUuid();
        }
    });

    @Override
    protected void insertResume(Resume resume, Integer index) {
        index = ~index;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(Integer index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected Integer getKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
