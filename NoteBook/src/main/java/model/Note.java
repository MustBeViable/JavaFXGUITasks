package model;

import java.util.HashMap;

public class Note {
    private String title;
    private String note;

    public Note(String title, String note) {
        this.note = note;
        this.title = title;
    }

    public Note getInstance() {
        return this;
    }

    public boolean editTitle(String newTitle) {
        if (newTitle.isEmpty()) {
            return false;
        } else {
            this.title = newTitle;
            return true;
        }
    }

    public boolean editNote(String newNote) {
        if (newNote.isEmpty()) {
            return false;
        } else {
            this.note = newNote;
            return true;
        }
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return this.title;
    }
}
