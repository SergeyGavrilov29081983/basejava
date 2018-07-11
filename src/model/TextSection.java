package model;

public class TextSection extends Section {

    private String content;

    @Override
    protected void setSection(Object content) {
        this.content = (String) content;
    }

    @Override
    protected String getSection() {
        return content;
    }
}
