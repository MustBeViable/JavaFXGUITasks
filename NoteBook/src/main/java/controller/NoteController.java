package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Note;
import model.NoteBook;
import view.NoteView;
import javafx.scene.control.*;

import java.awt.*;
import java.util.ArrayList;

public class NoteController {
    private NoteBook notes = new NoteBook();
    @FXML
    private TextField addNoteTitle, findNoteByTitle;
    @FXML
    private TextArea writeNoteText;
    @FXML
    private Label noteDisplayField, noteTitle1, noteTitle2, noteTitle3, noteTitle4, noteTitle5;
    @FXML
    private Label noteText1, noteText2, noteText3, noteText4, noteText5;
    @FXML
    private ListView<Note> listView;
    private final ObservableList<Note> obsNotes = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        obsNotes.setAll(notes.getNotes());
        listView.setItems(obsNotes);
        refreshNoteList();

        listView.setCellFactory(v -> new ListCell<>() {
            @Override protected void updateItem(Note n, boolean empty) {
                super.updateItem(n, empty);
                if (empty || n == null) {
                    setText(null);
                } else {
                    setText(n.getTitle());
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((o, old, selected) -> {
            if (selected == null) {
                noteDisplayField.setText("");
            } else {
                noteDisplayField.setText(selected.getNote());
            }
        });

        if (!obsNotes.isEmpty()) listView.getSelectionModel().selectFirst();
    }

    @FXML
    private void addNote() {
        System.out.println("addNotessa");
        String title = addNoteTitle.getText();
        String note = writeNoteText.getText();
        if (title.isEmpty()) {
            return;
        }
        if (notes.addNote(title,note)) {
            System.out.println("Yay onnistui");
        } else {
            System.out.println("Epäonnistui :(");
        }
        refreshNoteList();
        ObservableList<Note> notes1 = FXCollections.observableArrayList(notes.getNotes());
        listView.setItems(notes1);
    }

    @FXML
    private void displayNote() {
        System.out.println("Jee notee displayataa");
        String findTitle = findNoteByTitle.getText();
        String note;
        try {
            note = notes.findNote(findTitle).getNote();
            noteDisplayField.setText(note);
        } catch (NullPointerException e) {
            noteDisplayField.setText("Muistiinpanoa ei löytynyt. Tarkista kirjoititko oikein.");
        }
        refreshNoteList();
    }


    @FXML
    private void refreshNoteList() {
        noteTitle1.setText("");
        noteText1.setText("");
        noteTitle2.setText("");
        noteText2.setText("");
        noteTitle3.setText("");
        noteText3.setText("");
        noteTitle4.setText("");
        noteText4.setText("");
        noteTitle5.setText("");
        noteText5.setText("");
        Note[] noteList =new Note[5];
        for (int i = 0; i < 5; i++) {
            try {
                noteList[i] = notes.getNoteByIndex(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            noteTitle1.setText(noteList[0].getTitle());
            noteText1.setText(noteList[0].getNote());
            noteTitle2.setText(noteList[1].getTitle());
            noteText2.setText(noteList[1].getNote());
            noteTitle3.setText(noteList[2].getTitle());
            noteText3.setText(noteList[2].getNote());
            noteTitle4.setText(noteList[3].getTitle());
            noteText4.setText(noteList[3].getNote());
            noteTitle5.setText(noteList[4].getTitle());
            noteText5.setText(noteList[4].getNote());
        } catch (NullPointerException e) {
        }
    }

    @FXML
    private void deleteNote1() {
        notes.deleteNote(0);
        refreshNoteList();
    }

    @FXML
    private void deleteNote2() {
        notes.deleteNote(1);
        refreshNoteList();
    }

    @FXML
    private void deleteNote3() {
        notes.deleteNote(2);
        refreshNoteList();
    }

    @FXML
    private void deleteNote4() {
        notes.deleteNote(3);
        refreshNoteList();
    }

    @FXML
    private void deleteNote5() {
        notes.deleteNote(4);
        refreshNoteList();
    }

}
