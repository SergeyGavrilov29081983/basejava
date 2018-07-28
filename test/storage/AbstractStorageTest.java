package storage;

import exceptions.ExistStorageException;
import exceptions.NotExistStorageException;
import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class AbstractStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final String FULL_NAME_1 = "uuid11";
    private static final String FULL_NAME_2 = "uuid12";
    private static final String FULL_NAME_3 = "uuid13";
    private static final String FULL_NAME_4 = "uuid14";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
        RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
        RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
        RESUME_4 = new Resume(UUID_4, FULL_NAME_4);

        RESUME_1.putContact(ContactType.PHONE, "89005620780");
        RESUME_1.putContact(ContactType.SKYPE, "sergo7777778");
        RESUME_1.putContact(ContactType.EMAIL, "sierghiei_gavrilov_1983@mail.ru");
        RESUME_1.putContact(ContactType.LINKEDIN, "");
        RESUME_1.putContact(ContactType.GITHUB, "sergo777777");
        RESUME_1.putContact(ContactType.STACKOVERFLOW, "");
        RESUME_1.putContact(ContactType.HOMEPAGE, "");
        RESUME_1.putSection(SectionType.PERSONAL, new TextSection("a"));
        RESUME_1.putSection(SectionType.OBJECTIVE, new TextSection("b"));
        RESUME_1.putSection(SectionType.ACHIEVEMENT, new ListSection(Arrays.asList("1","2","3")));
        RESUME_1.putSection(SectionType.QUALIFICATIONS, new ListSection(Arrays.asList("1","2","3")));
        RESUME_1.putSection(SectionType.EXPERIENCE, new OrganizationSection(Arrays.asList(new Organization("1", "2", Arrays.asList(new DateAndDescription(LocalDate.of(1,2,3), LocalDate.of(1,2,3), "a", "b"))))));
        RESUME_1.putSection(SectionType.EDUCATION, new OrganizationSection(Arrays.asList(new Organization("1", "2", Arrays.asList(new DateAndDescription(LocalDate.of(1,2,3), LocalDate.of(1,2,3), "a", "b"))))));
    }



    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }


    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_2);
        storage.save(RESUME_1);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test
    public void update() throws Exception {
        storage.update(RESUME_1);
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(RESUME_4);
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test()
    public void delete() throws Exception {
        storage.delete(UUID_1);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(RESUME_4.getUuid());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] expectedStorage = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        Assert.assertEquals(expectedStorage[0], storage.get(UUID_1));
        Assert.assertEquals(expectedStorage[1], storage.get(UUID_2));
        Assert.assertEquals(expectedStorage[2], storage.get(UUID_3));
        Assert.assertEquals(3, storage.size());
        Assert.assertArrayEquals(expectedStorage, storage.getAllSorted().toArray());
    }

    @Test
    public void putContact() {
        RESUME_1.putContact(ContactType.PHONE, "1");
        Assert.assertEquals("1" ,RESUME_1.getContact(ContactType.PHONE));
    }
}