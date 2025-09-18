package model;

import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> dictionary = new HashMap<>();

    public boolean addWordToDictionary (String word, String definition) {
        try {
            if (!this.dictionary.containsKey(word)) {
                this.dictionary.put(word.toLowerCase(), definition);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public String findDefinition (String word) {
        if (this.dictionary.containsKey(word.toLowerCase())) {
            return this.dictionary.get(word.toLowerCase());
        } else {
            String str = "There is no " + word + " in the dictionary.";
            return str;
        }
    }

}
