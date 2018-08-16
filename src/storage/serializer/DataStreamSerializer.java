package storage.serializer;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, Section> sections = r.getSections();
            dos.write(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                if (type == SectionType.PERSONAL) {
                    dos.writeUTF(entry.getKey().name());
                    TextSection personal = (TextSection) entry.getValue();
                    dos.writeUTF(personal.getContent());
                }
                if (type == SectionType.OBJECTIVE) {
                    dos.writeUTF(entry.getKey().name());
                    TextSection objective = (TextSection) entry.getValue();
                    dos.writeUTF(objective.getContent());
                }
                if (type == SectionType.ACHIEVEMENT) {
                    ListSection achievement = (ListSection) entry.getValue();
                    List<String> list = achievement.getList();
                    dos.write(list.size());
                    for (String item : list) {
                        dos.writeUTF(item);
                    }
                    dos.writeUTF(entry.getKey().name());
                }
                if (type == SectionType.QUALIFICATIONS) {
                    ListSection qualifications = (ListSection) entry.getValue();
                    List<String> list = qualifications.getList();
                    dos.write(list.size());
                    for (String item : list) {
                        dos.writeUTF(item);
                    }
                    dos.writeUTF(entry.getKey().name());
                }
                if (type == SectionType.EXPERIENCE) {
                    dos.writeUTF(entry.getKey().name());
                    OrganizationSection experience = (OrganizationSection) entry.getValue();
                    List<Organization> list = experience.getOrganizations();
                    dos.write(list.size());
                    for (Organization organization : list) {
                        Link homepage = organization.getHomePage();
                        dos.writeUTF(homepage.getName());
                        dos.writeUTF(homepage.getUrl());
                        dos.writeUTF(organization.getTitle());
                        List<Organization.Position> positions = organization.getPositions();
                        dos.write(positions.size());
                        for (Organization.Position position : positions) {
                            dos.write(position.getStartDate().getMonthValue());
                            dos.write(position.getStartDate().getYear());
                            dos.write(position.getEndDate().getMonthValue());
                            dos.write(position.getEndDate().getYear());
                            dos.writeUTF(position.getTitle());
                            dos.writeUTF(position.getDescription());
                        }
                    }
                }
                if (type == SectionType.EDUCATION) {

                    OrganizationSection education = (OrganizationSection) entry.getValue();
                    List<Organization> list = education.getOrganizations();
                    for (Organization organization : list) {
                        Link homepage = organization.getHomePage();
                        dos.writeUTF(homepage.getName());
                        dos.writeUTF(homepage.getUrl());
                        dos.writeUTF(organization.getTitle());
                        List<Organization.Position> positions = organization.getPositions();
                        for (Organization.Position position : positions) {
                            dos.write(position.getStartDate().getMonthValue());
                            dos.write(position.getStartDate().getYear());
                            dos.write(position.getEndDate().getMonthValue());
                            dos.write(position.getEndDate().getYear());
                            dos.writeUTF(position.getTitle());
                            dos.writeUTF(position.getDescription());
                        }
                    }
                    dos.writeUTF(entry.getKey().name());
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            resume.addSection(SectionType.valueOf(dis.readUTF()), new TextSection(dis.readUTF()));
            resume.addSection(SectionType.valueOf(dis.readUTF()), new TextSection(dis.readUTF()));

            List<String> achievement = new ArrayList<>();
            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                achievement.add(dis.readUTF());
            }
            resume.addSection(SectionType.valueOf(dis.readUTF()), new ListSection(achievement));

            List<String> qualifications = new ArrayList<>();
            int count1 = dis.readInt();
            for (int i = 0; i < count1; i++) {
                achievement.add(dis.readUTF());
            }
            resume.addSection(SectionType.valueOf(dis.readUTF()), new ListSection(qualifications));

            int count2 = dis.readInt();
            for (int i = 0; i < count2; i++) {
                Link link = new Link(dis.readUTF(), dis.readUTF());
                String title = dis.readUTF();
                int positionCount = dis.readInt();
                for (int k = 0; k < positionCount; i++) {
                    int month = dis.readInt();
                    int year = dis.readInt();
                    int monthEnd = dis.readInt();
                    int yearEnd = dis.readInt();
                    String titlePos = dis.readUTF();
                    String description = dis.readUTF();

                }
            }

            resume.addSection(SectionType.valueOf(dis.readUTF()), new OrganizationSection());




            return resume;
        }
    }
}
