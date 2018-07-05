package model;

public enum ResumeContacts {

    PHONE("Телефон:"),
    SKYPE("Skype:"),
    EMAIL("Почта:"),
    LINKEDIN("профиль LinkedIn"),
    GITHUB("профиль Github"),
    STACKOVERFLOW("профиль StackOverFlow"),
    HOMEPAGE("Домашняя страница:");

    private String title;

    ResumeContacts(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
