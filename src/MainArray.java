import model.*;
import storage.ArrayStorage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Test for com.urise.webapp.storage.storage.ArrayStorage
 */
public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Resume r;
//        while (true) {
//            System.out.print("Введите одну из команд - (list | save uuid | update uuid | delete uuid | get uuid | clear | exit): ");
//            String[] params = reader.readLine().trim().toLowerCase().split(" ");
//            if (params.length < 1 || params.length > 2) {
//                System.out.println("Неверная команда.");
//                continue;
//            }
//            String uuid = null;
//            String fullName = null;
//            if (params.length == 2) {
//                uuid = params[1].intern();
//            }
//            switch (params[0]) {
//                case "list":
//                    printAll();
//                    break;
//                case "size":
//                    System.out.println(ARRAY_STORAGE.size());
//                    break;
//                case "save":
//                    r = new Resume(uuid, fullName);
//
//                    ARRAY_STORAGE.save(r);
//                    printAll();
//                    break;
//                case "update":
//                    r = new Resume("sergo");
//                    ARRAY_STORAGE.update(r);
//                    printAll();
//                    break;
//                case "delete":
//                    ARRAY_STORAGE.delete(uuid);
//                    printAll();
//                    break;
//                case "get":
//                    System.out.println(ARRAY_STORAGE.get(uuid));
//                    break;
//                case "clear":
//                    ARRAY_STORAGE.clear();
//                    printAll();
//                    break;
//                case "exit":
//                    return;
//                default:
//                    System.out.println("Неверная команда.");
//                    break;
//            }
//        }
//    }
//
//    static void printAll() {
//        List<Resume> all = ARRAY_STORAGE.getAllSorted();
//        System.out.println("----------------------------");
//        assert all != null;
//        if (all.isEmpty()) {
//            System.out.println("Empty");
//        } else {
//            for (Resume r : all) {
//                System.out.println(r);
//            }
//        }
//        System.out.println("----------------------------");
//    }

    public static void main(String[] args) {
        Resume resume = new Resume("Gavrillov Sergey");
        resume.putContact(Contacts.PHONE, "89005620780");
        resume.putContact(Contacts.SKYPE, "sergo77777778");
        resume.putContact(Contacts.EMAIL, "sierghiei_gavriov_1983@mail.ru");
        resume.putContact(Contacts.LINKEDIN, " ");
        resume.putContact(Contacts.GITHUB, "sergo7777777");
        resume.putContact(Contacts.STACKOVERFLOW, " ");
        resume.putContact(Contacts.HOMEPAGE, " ");

        resume.putSection( SectionType.PERSONAL, new TextSection(" "));
        resume.putSection(SectionType.OBJECTIVE, new TextSection(" "));
        resume.putSection(SectionType.ACHIEVEMENT, new ListSection(new String[]{"", "", ""}));
        resume.putSection(SectionType.QUALIFICATIONS, new ListSection(new String[]{"", "", ""}));
        resume.putSection(SectionType.EXPERIENCE, new ReferenceSection(new ArrayList<>(Collections.singletonList(new ReferenceObject("", "1", "2", "")))));
        resume.putSection(SectionType.EDUCATION, new ReferenceSection(new ArrayList<>(Collections.singletonList(new ReferenceObject("", "1", "2", "")))));
    }

}
