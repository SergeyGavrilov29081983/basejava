package model;

public class TextSection extends Section {

    private String description;

    @Override
    protected void set(String data, String description, String reference) {
        this.description = description;
    }

    @Override
    protected String get() {
        return description;
    }
}
