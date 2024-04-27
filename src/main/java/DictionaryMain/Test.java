package DictionaryMain;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        DictionaryManagement dict = new DictionaryManagement();
        DictionaryCommandline DictionaryCommandLine = new DictionaryCommandline();

        DictionaryCommandLine.dictionaryBasic(dict);
        DictionaryCommandLine.dictionaryAdvanced(dict);
        DictionaryCommandLine.dictionarySearcher(dict);
    }
}

