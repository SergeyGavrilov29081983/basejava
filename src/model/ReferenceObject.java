package model;

public class ReferenceObject {

    private String title;
    private String startDate;
    private String localDate;
    private String description;

    public ReferenceObject(String title, String startDate, String localDate, String description) {
        this.title = title;
        this.startDate = startDate;
        this.localDate = localDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getLocalDate() {
        return localDate;
    }

    public String getDescription() {
        return description;
    }
}
