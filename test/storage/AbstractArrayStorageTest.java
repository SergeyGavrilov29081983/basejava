package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import exceptions.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public abstract class AbstractArrayStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() {
        Resume resume = new Resume("uuid1");
        Assert.assertEquals(resume.getUuid(), UUID_1);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test
    public void update() {
        Resume resume = new Resume("uuid1");
        storage.update(new Resume(UUID_1));
        Assert.assertEquals(resume.getUuid(), UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(new Resume());
    }

    @Test
    public void get() {
        Resume resume = new Resume("uuid1");
        Assert.assertEquals(resume.getUuid(), storage.get(UUID_1).toString());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("uuid4");
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] storageExpected = new Resume[3];
        storageExpected[0] = new Resume(UUID_1);
        storageExpected[1] = new Resume(UUID_2);
        storageExpected[2] = new Resume(UUID_3);
        Assert.assertArrayEquals(storageExpected, storage.getAll());
    }

    @Test(expected = ExistStorageException.class)
    public void getExist() {
        storage.save(new Resume(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void storageOverflow() {
        for (int i = 0; i < 10000; i++) {
            storage.save(new Resume());
        }
    }
}