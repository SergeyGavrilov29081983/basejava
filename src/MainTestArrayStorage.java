/*
import model.Resume;
import storage.ArrayStorage;
import storage.ListStorage;
import storage.SortedArrayStorage;

*/
/**
 * Test for com.urise.webapp.storage.storage.ArrayStorage
 *//*

public class MainTestArrayStorage {
    static final ListStorage SORTED_ARRAY_STORAGE = new ListStorage();
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {

        String uuid = null;

        final Resume r1 = new Resume();
        //r1.setUuid("uuid1");

        final Resume r2 = new Resume();
        //r2.setUuid("uuid2");

        final Resume r3 = new Resume();
        //r3.setUuid("uuid3");

        Resume r4 = new Resume();
        //r4.setUuid("uuid4");

        Resume r5 = new Resume();
        //r5.setUuid("uuid5");

        SORTED_ARRAY_STORAGE.save(r1);
        SORTED_ARRAY_STORAGE.save(r2);
        SORTED_ARRAY_STORAGE.save(r3);
        SORTED_ARRAY_STORAGE.save(r4);
        SORTED_ARRAY_STORAGE.save(r1);

        System.out.println("Get r1: " + SORTED_ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());

        //System.out.println("Get dummy: " + SORTED_ARRAY_STORAGE.get("dummy"));

        printAll();
        SORTED_ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        SORTED_ARRAY_STORAGE.update(r2);
        printAll();
        SORTED_ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + SORTED_ARRAY_STORAGE.size());

    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : SORTED_ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
*/
