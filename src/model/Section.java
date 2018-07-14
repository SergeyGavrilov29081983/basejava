package model;

public abstract class Section {

    public void setContent(String data, String description, String reference) {
        set(data, description, reference);
    }

    public Object getContent() {
        return get();
    }

    protected abstract void set(String data, String description, String reference);

    protected abstract Object get();
}
