package model;

import java.time.LocalDate;
import java.util.Objects;

public class DateAndDescription {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public DateAndDescription(LocalDate startDate, LocalDate endDate, String title, String description) {
        Objects.requireNonNull(startDate, "startDate must be not null!");
        Objects.requireNonNull(endDate, "endDate must be not null!");
        Objects.requireNonNull(title, "title must be not null!");
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DateAndDescription{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateAndDescription that = (DateAndDescription) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(startDate, endDate, title, description);
    }
}
