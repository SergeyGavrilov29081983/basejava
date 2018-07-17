package model;

public class ReferenceObject {

    private String reference;
    private String[] data;
    private String description;

    public ReferenceObject(String reference, String[] data, String description) {
        this.reference = reference;
        this.data = data;
        this.description = description;
    }

    public String getReference() {
        return reference;
    }

    public String[] getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }
}
