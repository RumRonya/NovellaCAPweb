package novella_models.playprogressparts;

import java.time.LocalDateTime;

public class Note {
    private int ID;
    private String person;
    private String text;
    private LocalDateTime date;

    public Note(int ID, String person, String text, LocalDateTime date) {
        this.ID = ID;
        this.person = person;
        this.text = text;
        this.date = date;
    }

    public Note(int ID, String person, String text) {
        this.ID = ID;
        this.person = person;
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public Note(String person, String text, LocalDateTime date) {
        this.person = person;
        this.text = text;
        this.date = date;
    }

    public Note(String person, String text) {
        this.person = person;
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
