package model;

public enum Contacts {

    PHONE("Phone"),
    SKYPE("Skype"),
    EMAIL("Email"),
    LINKEDIN("Linkedin"),
    GITHUB("Github"),
    STACKOVERFLOW("StackOverFlow"),
    HOMEPAGE("Homepage");

    private String title;

    Contacts(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
