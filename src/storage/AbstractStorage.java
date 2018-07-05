package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.Resume;

import java.util.*;
import java.util.logging.Logger;


public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOGGER = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public final void save(Resume resume) {
        LOGGER.info("save " + resume);
        SK key = getKeyIfResumeNotExist(resume.getUuid());
        saveElement(resume, key);
    }

    @Override
    public final void update(Resume resume) {
        LOGGER.info("update " + resume);
        SK key = getKeyIfResumeExist(resume.getUuid());
        updateElement(resume, key);
    }

    @Override
    public final Resume get(String uuid) {
        LOGGER.info("get " + uuid);
        SK key = getKeyIfResumeExist(uuid);
        return getElement(key);
    }

    @Override
    public final void delete(String uuid) {
        LOGGER.info("delete " + uuid);
        SK key = getKeyIfResumeExist(uuid);
        deleteElement(key);
    }

    private SK getKeyIfResumeExist(String uuid) {
        SK key = getKey(uuid);
        if (!isExist(key)) {
            LOGGER.warning("Resume "  + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private SK getKeyIfResumeNotExist(String uuid) {
        SK key = getKey(uuid);
        if (isExist(key)) {
            LOGGER.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOGGER.info("getAllSorted");
        List<Resume> list = getStorage();
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    protected abstract SK getKey(String uuid);

    protected abstract void saveElement(Resume resume, SK key);

    protected abstract void updateElement(Resume resume, SK key);

    protected abstract Resume getElement(SK key);

    protected abstract void deleteElement(SK key);

    protected abstract boolean isExist(SK key);

    protected abstract List<Resume> getStorage();
}




