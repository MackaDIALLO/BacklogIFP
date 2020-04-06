package domain;

public class Tag {

    private int id;
    private String nameTag;

    public Tag(int id, String nameTag) {
        this.id = id;
        this.nameTag = nameTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }
}
