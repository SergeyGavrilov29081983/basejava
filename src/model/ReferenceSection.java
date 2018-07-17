package model;


import java.util.ArrayList;
import java.util.List;

public class ReferenceSection extends Section {

    List<ReferenceObject> list = new ArrayList<>();

    public ReferenceSection(String reference, String[] data, String description) {
        list.add(new ReferenceObject(reference, data, description));
    }

    public List<ReferenceObject> get() {
        return list;
    }
}
