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
        notes.add(new Note("" +
                "Esimerkki note1", "Muista, että banaani kypsyy nopeammin paperipussissa. Älä kuitenkaan unohda " +
                "sitä viikoksi."));
        notes.add(new Note("Esimerkki note2", "" +
                "Pilven varjo näytti hetken kuin kartalta, jossa meri oli keskellä metsää. Ei jatkotoimia."));
        notes.add(new Note("Esimerkki note3", "" +
                "Jos teepussi putoaa lattialle, se muuttuu siivousprojektiksi. Tee uusi."));
        notes.add(new Note("Esimerkki note4", "" +
                "Post-it, jossa luki “älä unohda”, katosi. Ironia hyväksytään"));
        notes.add(new Note("Esimerkki note5", "" +
                "Tyhjä lasipurkki tuntuu painavalta, kun se on täynnä odotuksia. Sulje kansi silti."));
        System.out.println(notes.size());
    }
}
