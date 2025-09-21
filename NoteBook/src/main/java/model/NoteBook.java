package model;

import java.util.ArrayList;

public class NoteBook {
    private final ArrayList<Note> notes = new ArrayList<>();

    public NoteBook() {
        addNotes();
    }

    public boolean addNote(String title, String note) {
        for (Note n : notes) {
            if (n.getTitle().equalsIgnoreCase(title)) {
                return false;
            }
        }
        notes.add(0,new Note(title,note));
        return true;
    }

    public Note findNote(String title) {
        for (Note n : notes) {
            if (n.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Note: " + n.getInstance().getNote());
                return n.getInstance();
            }
        } return null;
    }

    public Note getNoteByIndex(int index) {
        if (notes.isEmpty()) {
            return null;
        } return notes.get(index).getInstance();
    }

    public void deleteNote(int index) {
        if (notes.size() >= (index-1)) {
            notes.remove(index);
        }
    }

    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    private void addNotes() {
        notes.add(new Note("Ripuli", "Ripuli on märkää kakkaa"));
        notes.add(new Note("Kakka", "Kakka on kuivaa ripulia"));
        notes.add(new Note("Note", "Hieno note jeejee"));
        notes.add(new Note("Kauppalista", "Kurkku, rasvaa, kondoomi"));
        notes.add(new Note("Tärkee!!", "En uskalla puhua tytöille :("));
        System.out.println(notes.size());
    }
}
