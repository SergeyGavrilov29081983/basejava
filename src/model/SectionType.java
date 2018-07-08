package model;

public enum SectionType {
    PHONE("Телефон:"),
    SKYPE("Skype:"),
    EMAIL("Почта:"),
    LINKEDIN("профиль LinkedIn"),
    GITHUB("профиль Github"),
    STACKOVERFLOW("профиль StackOverFlow"),
    HOMEPAGE("Домашняя страница:"),
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    private String title;

    SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
