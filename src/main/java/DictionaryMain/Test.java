package DictionaryMain;

public class 2Test {
    public static void main(String[] args) {
        DictionaryManagement dict = new DictionaryManagement();

        DictionaryCommandLine.dictionaryBasic(dict);
        DictionaryCommandLine.dictionaryAdvanced(dict);
        DictionaryCommandLine.dictionarySearcher(dict);

    }
}

