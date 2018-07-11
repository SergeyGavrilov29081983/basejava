package model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends Section {

    private List<String> list = new ArrayList<>();

    @Override
    protected void setSection(Object content) {
        list.add((String) content);
    }

    @Override
    protected Object getSection() {
        return list;
    }
}
