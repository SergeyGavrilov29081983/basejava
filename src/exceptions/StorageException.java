package exceptions;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String io_error, String uuid, Exception e) {
        super(io_error, e);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
