package model;

public class Contacts extends Section {

    private String phone;
    private String skype;
    private String email;
    private String linkedin;
    private String github;
    private String stackoverflow;
    private String homepage;

    public Contacts(String phone, String skype, String email, String linkedin, String github, String stackoverflow, String homepage) {
        this.phone = phone;
        this.skype = skype;
        this.email = email;
        this.linkedin = linkedin;
        this.github = github;
        this.stackoverflow = stackoverflow;
        this.homepage = homepage;
    }

    public String getPhone() {
        return phone;
    }

    public String getSkype() {
        return skype;
    }

    public String getEmail() {
        return email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGithub() {
        return github;
    }

    public String getStackoverflow() {
        return stackoverflow;
    }

    public String getHomepage() {
        return homepage;
    }
}
