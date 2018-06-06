package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import exceptions.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    Storage storage;

    public AbstractArrayStorageTest(Storage storage){
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

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
        storage.save(new Resume("uuid4"));
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
    }

    @Test
    public void get() {
        storage.get(UUID_1);
    }

    @Test
    public void delete() {
        storage.delete(UUID_1);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void getAll() {
        Assert.assertArrayEquals(storage.getAll(), storage.getAll());
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