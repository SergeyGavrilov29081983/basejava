package storage;

public class ObjectOutputStreamTest extends AbstractStorageTest {


    public ObjectOutputStreamTest() {
        super(new AbstractPathStorage(STORAGE_DIR.toString(), new ObjectStreamStorage()));
    }
}
