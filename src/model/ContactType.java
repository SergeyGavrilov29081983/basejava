package model;

public enum ContactType {

    PHONE("Phone"),
    SKYPE("Skype"),
    EMAIL("Email"),
    LINKEDIN("Linkedin"),
    GITHUB("Github"),
    STACKOVERFLOW("StackOverFlow"),
    HOMEPAGE("Homepage");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
