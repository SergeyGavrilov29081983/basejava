package model;


import java.util.ArrayList;
import java.util.List;

public class ReferenceSection extends Section {

    private List<ReferenceObject> list;

    public ReferenceSection(List<ReferenceObject> list) {
        this.list =list;
    }

    public List<ReferenceObject> get() {
        return list;
    }
}
