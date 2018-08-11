package storage;

import exceptions.StorageException;
import model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbstractFileStorage extends AbstractStorage<File> {

    private File directory;
    private Serializer serializer;

    public AbstractFileStorage(File directory, Serializer serializer) {
        Objects.requireNonNull(directory, "directory must be not null!");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
        this.serializer = serializer;
    }

    @Override
    protected File getKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void saveElement(Resume resume, File file) {

        try {
            file.createNewFile();
            updateElement(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void updateElement(Resume resume, File file) {
        try {
            serializer.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume getElement(File file) {
        try {
            return serializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void deleteElement(File file) {
        boolean isDeleted = file.delete();
        if (!isDeleted) {
            throw new StorageException("IO error", file.getName());
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getStorage() {
        List<Resume> resumes = new ArrayList<>();
        for (File file : getFiles()) {
            resumes.add(getElement(file));
        }
        return resumes;
    }

    @Override
    public void clear() {
        for (File file : getFiles()) {
            deleteElement(file);
        }
    }


    @Override
    public int size() {
        return getFiles().length;
    }

    private File[] getFiles() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("directory is empty", directory.getName());
        }
        return files;
    }
}