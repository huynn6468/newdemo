package DictionaryMain;
import java.util.ArrayList;
public class Test {

    public static void main(String[] args) {
        DictionaryManagement dict = new DictionaryManagement();
        DictionaryCommandline DictionaryCommandline = new DictionaryCommandline();
        DictionaryCommandline = null;
        DictionaryMain.DictionaryCommandline.dictionaryBasic(dict);
        DictionaryCommandline.dictionaryAdvanced(dict);
        DictionaryCommandline.dictionarySearcher(dict);

    }
}

