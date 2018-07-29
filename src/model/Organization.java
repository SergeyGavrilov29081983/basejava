package model;

import java.util.List;
import java.util.Objects;

public class Organization {

    private final List<DateAndDescription> dateAndDescriptions;
    private final Link homepage;
    private final String description;


    public Organization(String name, String url, List<DateAndDescription> dateAndDescriptions, String description) {
        this.homepage = new Link(name, url);
        this.dateAndDescriptions = dateAndDescriptions;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "dateAndDescriptions=" + dateAndDescriptions +
                ", homepage=" + homepage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(dateAndDescriptions, that.dateAndDescriptions) &&
                Objects.equals(homepage, that.homepage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dateAndDescriptions, homepage);
    }
}
