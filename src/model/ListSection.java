package model;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {

    private final List<String> list;

    public ListSection(List<String> list) {
        Objects.requireNonNull(list, "list must be not null!");
        this.list = list;
    }

    public List<String> get() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
