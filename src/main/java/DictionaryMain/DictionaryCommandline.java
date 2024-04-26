package DictionaryMain;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {
    private static final Scanner sc = new Scanner(System.in);
    private DictionaryManagement dict;
    private String target;

    public static void dictionaryBasic(DictionaryManagement dict) {
        dict.insertFromCommandline();
        System.out.println("\n");
        dict.showAllWords();
        System.out.println("\n");
    }

    public static void dictionaryAdvanced(DictionaryManagement dict) {
        dict.insertFromFile();
        System.out.println("\n");
        dict.showAllWords();
        System.out.println("\n");
        System.out.println("Nhập từ tiếng Anh: ");
        String target = sc.nextLine();
        System.out.println(dict.dictionaryLookup(target));
        System.out.println("\n");
        dict.editWord();
        System.out.println("\n");
        dict.dictionaryExportToFile();
        System.out.println("\n");
    }

    public int dictionarySearcher(DictionaryManagement dict, String target) {
        Dictionary.wordArray.sort(Comparator.comparing(Word::getWordTarget));
        int l = 0;
        int r = Dictionary.wordArray.size() - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            String wordTarget = Dictionary.wordArray.get(mid).getWordTarget();
            int comparisonResult = target.compareTo(wordTarget);
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public void dictionarySearcher(DictionaryManagement dict) {
    }
}
