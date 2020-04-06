package domain;

public class Rating{

    private int id;
    private String commentary;
    private boolean valid;
    private int note;

    public Rating(int id, String commentary, boolean valid, int note) {
        this.id = id;
        this.commentary = commentary;
        this.valid = valid;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
