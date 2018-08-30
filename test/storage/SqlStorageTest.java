package storage;

import config.Config;

public class SqlStorageTest extends AbstractStorageTest{

    public SqlStorageTest() {

        super(new SqlStorage(Config.get().getDburl(), Config.get().getDbuser(), Config.get().getDbpassword()));
    }
}
