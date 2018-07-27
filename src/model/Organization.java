package model;

import java.util.List;
import java.util.Objects;

public class Organization {

    private final List<DateAndDescription> dateAndDescriptions;
    private final Link homepage;
    private final String title;

    public Organization(String name, String url, String title, List<DateAndDescription> dateAndDescriptions) {
        Objects.requireNonNull(title, "title must be not null!");
        this.homepage = new Link(name, url);
        this.title = title;
        this.dateAndDescriptions = dateAndDescriptions;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "dateAndDescriptions=" + dateAndDescriptions +
                ", homepage=" + homepage +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(dateAndDescriptions, that.dateAndDescriptions) &&
                Objects.equals(homepage, that.homepage) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dateAndDescriptions, homepage, title);
    }
}
