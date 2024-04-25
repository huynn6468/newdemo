package DictionaryMain;

public class Word implements Comparable<Word> {

    private String WordTarget;
    private String WordExplain;
    private String Hehe;

    public Word() {
    }
    public Word(String wordTarget) {
        this.WordTarget = WordTarget;
    }
    public Word(String wordTarget, String wordExplain) {
        this.WordTarget = WordTarget;
        this.WordExplain = WordExplain;
    }

    public String getWordTarget() {
        return WordTarget;
    }

    public void setWordTarget(String wordTarget) {
        WordTarget = wordTarget;
    }

    public String getWordExplain() {
        return WordExplain;
    }

    public void setWordExplain(String wordExplain) {
        WordExplain = wordExplain;
    }

    public int compareTo(Word other) {
        return WordTarget.compareTo(other.WordTarget);
    }
}
