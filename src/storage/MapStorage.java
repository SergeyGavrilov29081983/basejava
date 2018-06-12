package storage;

import model.Resume;


public class MapStorage extends AbstractStorage {

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void clearStorage() {
    }

    @Override
    protected void saveElement(Resume resume, int index, String uuid) {

    }

    @Override
    protected void updateElement(Resume resume, int index, String uuid) {

    }

    @Override
    protected Resume getElement(int index, String uuid) {
        return null;
    }

    @Override
    protected void deleteElement(int index, String uuid) {

    }

    @Override
    protected Resume[] getAllElements() {
        return new Resume[0];
    }

    @Override
    protected int storageSize() {
        return 0;
    }
}
