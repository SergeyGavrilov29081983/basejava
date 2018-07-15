package model;

public class TextSection extends Section {

    private String description;

    public TextSection(String description) {
        this.description = description;
    }

    protected String get() {
        return description;
    }
}
