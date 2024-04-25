package DictionaryMain;

import java.util.ArrayList;

public abstract class Dictionary {
    protected static ArrayList<Word> wordArray;
    public Dictionary() {
        wordArray = new ArrayList<>();
    }
    public ArrayList<Word> getWordArray() {
        return this.wordArray;
    }

}

