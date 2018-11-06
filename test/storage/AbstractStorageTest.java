package storage;


import config.Config;
import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.PHONE, "89005620780");
        R1.addContact(ContactType.SKYPE, "sergo7777778");
        R1.addContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        R1.addContact(ContactType.LINKEDIN, "");
        R1.addContact(ContactType.GITHUB, "sergo777777");
        R1.addContact(ContactType.STACKOVERFLOW, "5555");
        R1.addContact(ContactType.HOMEPAGE, "4444");
        R1.addSection(SectionType.PERSONAL, new TextSection("a"));
        R1.addSection(SectionType.OBJECTIVE, new TextSection("b"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("1", "2", "3")));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("1", "2", "3")));

        R2.addContact(ContactType.PHONE, "8900562078");
        R2.addContact(ContactType.SKYPE, "sergo7777778");
        R2.addContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        R2.addContact(ContactType.LINKEDIN, "");
        R2.addContact(ContactType.GITHUB, "sergo777777");
        R2.addContact(ContactType.STACKOVERFLOW, "5555");
        R2.addContact(ContactType.HOMEPAGE, "4444");


        R3.addContact(ContactType.PHONE, "89005620780");
        R3.addContact(ContactType.SKYPE, "sergo7777778");
        R3.addContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        R3.addContact(ContactType.LINKEDIN, "");
        R3.addContact(ContactType.GITHUB, "sergo777777");
        R3.addContact(ContactType.STACKOVERFLOW, "5555");
        R3.addContact(ContactType.HOMEPAGE, "4444");

        R4.addContact(ContactType.PHONE, "89005620780");
        R4.addContact(ContactType.SKYPE, "sergo7777778");
        R4.addContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        R4.addContact(ContactType.LINKEDIN, "");
        R4.addContact(ContactType.GITHUB, "sergo777777");
        R4.addContact(ContactType.STACKOVERFLOW, "5555");
        R4.addContact(ContactType.HOMEPAGE, "4444");
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void size() throws Exception {
        assertSize(3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() throws Exception {
        Resume r5 = new Resume(UUID_1, "newResume");

        r5.addContact(ContactType.PHONE, "89005620780");
        r5.addContact(ContactType.SKYPE, "sergo7777778");
        r5.addContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        r5.addContact(ContactType.LINKEDIN, "");
        r5.addContact(ContactType.GITHUB, "sergo777777");
        r5.addContact(ContactType.STACKOVERFLOW, "5555");
        r5.addContact(ContactType.HOMEPAGE, "3443");
        storage.update(r5);
        assertEquals(r5,(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(R4);
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List sortedResumes = Arrays.asList(R1, R2, R3);
        assertEquals(sortedResumes, list);
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
            storage.save(R1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    private void assertGet(Resume r) throws Exception {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }


}
