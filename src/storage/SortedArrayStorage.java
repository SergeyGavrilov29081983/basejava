package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume){

            Resume searchKey = new Resume();
            searchKey.setUuid(resume.getUuid());
            int index = -(Arrays.binarySearch(storage, 0, size, searchKey) + 1);
            System.arraycopy(storage, index, storage, index + 1, size - index);
            System.out.println(index);
            storage[index] = resume;



        //Arrays.sort(storage,0,size);
    }

    @Override
    protected void doDelete(int index) {
        System.arraycopy(storage, index + 1, storage, index, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        int index = Arrays.binarySearch(storage, 0, size, searchKey);
        if (index >= 0) {
            return index;
        }
        return -1;
    }
}
