package DictionaryMain;

public class Test {
    public static void main(String[] args) {
        DictionaryManagement dict = new DictionaryManagement();
        DictionaryCommandline DictionaryCommandLine = null;
        DictionaryCommandline.dictionaryBasic(dict);
        DictionaryCommandline.dictionaryAdvanced(dict);
        DictionaryCommandLine.dictionarySearcher(dict);
    }
}

