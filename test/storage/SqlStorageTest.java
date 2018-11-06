package storage;

import config.Config;

public class SqlStorageTest extends AbstractStorageTest {

    //private static final Resume R1 = new Resume("uuid1", "Name1");

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }

}
