package model;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReferenceSection extends Section {

    private String reference;
    private String data;
    private String description;


    @Override
    protected void set(String data, String description, String reference) {
        this.reference = reference;
        this.data = data;
        this.description = description;
    }

    @Override
    protected List<String> get() {
        return new ArrayList<>(Arrays.asList(reference, data, description));
    }
}
