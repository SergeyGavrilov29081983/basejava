package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSection extends Section {

    private List<String> list;

    public ListSection(String[] description) {
        this.list = Arrays.asList(description);
    }

    public List<String> get() {
        return list;
    }
}
