package model;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Objects;
import java.util.UUID;

/**
 * com.urise.webapp.model.model.Resume class
 */
public class Resume implements Comparable<Resume>, Serializable {

    private static final long serialVersionUID = 1L;

    // Unique identifier
    private final String uuid;
    private final String fullName;
    private final EnumMap<ContactType, String> contactTypeMap = new EnumMap<>(ContactType.class);
    private final EnumMap<SectionType, Section> sectionMap = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.fullName = fullName;
        this.uuid = uuid;
    }

    public void addContact(ContactType contact, String text) {
        contactTypeMap.put(contact, text);
    }

    public String getContact(ContactType contact) {
        return contactTypeMap.get(contact);
    }

    public void addSection(SectionType sectionType, Section section) {
        sectionMap.put(sectionType, section);
    }

    public Section getSection(SectionType sectionType) {
        return sectionMap.get(sectionType);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contactTypeMap, resume.contactTypeMap) &&
                Objects.equals(sectionMap, resume.sectionMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, fullName, contactTypeMap, sectionMap);
    }

    @Override
    public int compareTo(Resume resume) {
        int cmp = fullName.compareTo(resume.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(resume.uuid);
    }
}
