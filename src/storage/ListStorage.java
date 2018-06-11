package storage;

import model.Resume;

public class ListStorage extends AbstractStorage {

    protected int getIndex(String uuid){
        Resume resume = new Resume(uuid);
         return storage.indexOf(resume);
    }
}
