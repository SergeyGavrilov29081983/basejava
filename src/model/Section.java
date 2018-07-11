package model;

public abstract class Section {

    public void set(Object content) {
        setSection(content);
    }

    public Object get(SectionType sectionType) {
        return getSection();
    }

    protected abstract void setSection(Object content);

    protected abstract Object getSection();
}
