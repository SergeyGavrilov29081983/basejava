package model;

import java.util.Objects;
import java.util.UUID;

/**
 * com.urise.webapp.model.model.Resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;
    private final String fullName;


    public Resume() {
        this(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return uuid;
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
        return Objects.equals(uuid, resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
