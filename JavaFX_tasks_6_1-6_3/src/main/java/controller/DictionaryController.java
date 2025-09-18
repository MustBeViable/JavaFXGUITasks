package controller;

import view.DictionaryView;
import model.Dictionary;

public class DictionaryController {

    private Dictionary dict = new Dictionary();
    private DictionaryView dictView = new DictionaryView();

    public DictionaryController(DictionaryView dw) {
        this.dictView = dw;
    }

    public void addWord(String word, String definition) {
        if (dict.addWordToDictionary(word, definition)) {
            System.out.println("word addeded");
        } else {
            System.out.println("word is already there");
        }
    }

    public void findWord(String word) {
        String definition = dict.findDefinition(word);
        System.out.println(definition);
        dictView.showDefinition(word, definition);
    }
}
