package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private File directory;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must be not null!");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void saveElement(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void updateElement(Resume resume, File file) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume getElement(File file) {
        return doRead(file);
    }

    @Override
    protected void deleteElement(File file) {
        file.delete();
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getStorage() {
        return null;
    }

    @Override
    public void clear() {
        for (File file: directory.listFiles()
             ) {
                file.delete();
        }
    }

    @Override
    public int size() {
        return directory.listFiles().length;
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;

    protected abstract Resume doRead(File file);
}
