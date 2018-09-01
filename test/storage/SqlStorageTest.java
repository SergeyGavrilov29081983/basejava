package storage;

import config.Config;
import exceptions.StorageException;
import model.Resume;
import org.junit.Test;
import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class SqlStorageTest extends AbstractStorageTest{

    private static final Resume R1 = new Resume("uuid1", "Name1");

    public SqlStorageTest() {

        super(new SqlStorage(new SqlHelper(Config.get().getDburl(), Config.get().getDbuser(), Config.get().getDbpassword())));
    }

   @Test(expected = StorageException.class)
    public void saveExist() throws Exception {
       try {
           storage.save(R1);
       } catch (PSQLException e) {
           throw new PSQLException("повторяющееся значение ключа нарушает ограничение уникальности", PSQLState.TRANSACTION_STATE_INVALID);
       }
   }
}
