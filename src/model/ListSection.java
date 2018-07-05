package model;

import java.util.Collections;
import java.util.List;

public class ListSection {

    private List listContent;

    public List getListContent() {
        return listContent;
    }

    public void setListContent(String listContent) {
        this.listContent = Collections.singletonList(listContent);
    }
}
