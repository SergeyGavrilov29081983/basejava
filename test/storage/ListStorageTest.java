package storage;


import exceptions.StorageException;
import org.junit.Ignore;
import org.junit.Test;

public class ListStorageTest extends AbstractStorageTest{

    public ListStorageTest() {
        super(new ListStorage());
    }

    @Ignore
    @Test(expected = StorageException.class)
    public void storageOverflow(){}
}