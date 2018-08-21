package storage.serializer;

import model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            Map<SectionType, Section> sections = resume.getSections();
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                dos.writeUTF(entry.getKey().name());
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(((TextSection) section).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(dos, ((ListSection) section).getList(), (dos::writeUTF));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> organizations = ((OrganizationSection) section).getOrganizations();
                        dos.write(organizations.size());
                        for (Organization organization : organizations) {
                            List<Organization.Position> positions = organization.getPositions();
                            dos.write(positions.size());
                            for (Organization.Position position : positions) {
                                dos.writeInt(position.getStartDate().getMonthValue());
                                dos.writeInt(position.getStartDate().getYear());
                                dos.writeInt(position.getEndDate().getMonthValue());
                                dos.writeInt(position.getEndDate().getYear());
                                dos.writeUTF(position.getTitle());
                                dos.writeUTF(position.getDescription());
                            }


                            dos.writeUTF(organization.getHomePage().getName());
                            dos.writeUTF(organization.getHomePage().getUrl());
                            dos.writeUTF(organization.getTitle());

                        }
                        break;
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

            Map<SectionType, Section> sections = resume.getSections();
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.addSection(type, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.addSection(type, new ListSection(reader(dis, dis::readUTF)));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> organizations = new ArrayList<>();
                        for (int i = 0; i < dis.readInt(); i++) {
                            List<Organization.Position> positions = new ArrayList<>();
                            for (int k = 0; k < dis.readInt(); i++) {
                                positions.add(new Organization.Position(LocalDate.of(dis.readInt(), dis.readInt(), 1), LocalDate.of(dis.readInt(), dis.readInt(), 1), dis.readUTF(), dis.readUTF()));
                            }
                            organizations.add(new Organization(new Link(dis.readUTF(), dis.readUTF()), dis.readUTF(), positions));
                        }
                        resume.addSection(type, new OrganizationSection(organizations));
                        break;
                }
            }
            return resume;

        }
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, WriteElement<T> writeElement) throws IOException {
        dos.write(collection.size());
        for (T elem : collection) {
            writeElement.write(elem);
        }

    }

    private <T> List<T> reader(DataInputStream dis, ReadElement<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }
}

interface WriteElement<T> {
    void write(T t) throws IOException;
}

interface ReadElement<T> {
    T read() throws IOException;
}





