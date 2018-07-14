package model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends Section {

    private List<String> list = new ArrayList<>();

    @Override
    protected void set(String data, String description, String reference) {
        list.add(description);
    }

    @Override
    protected List<String> get() {
        return list;
    }
}
