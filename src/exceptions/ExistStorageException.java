package exceptions;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("resume " + uuid  + " already exist",uuid);
    }
}
