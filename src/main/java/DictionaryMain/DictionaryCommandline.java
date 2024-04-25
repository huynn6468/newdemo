package DictionaryMain;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {
    public DictionaryCommandline() {
        super();
    }
    private static Scanner sc = new Scanner(System.in);

    public static void dictionaryBasic(DictionaryManagement dict) {
        dict.insertFromCommandline();
        System.out.println("\n");
        dict.showAllWord();
        System.out.println("\n");
    }

    public static void dictionaryAdvanced(DictionaryManagement dict) {
        dict.insertFromFile();
        System.out.println("\n");
        dict.showAllWord();
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

    public int dictionarySearcher(DictionaryManagement dict) {
        Collections.sort(Dictionary.wordArray, Comparator.comparing(Word::getWordTarget));
        int l = 0;
        int r = Dictionary.wordArray.size() - 1;
        while (r >= l) {
            int mid = l + (r - l) / 2;
            if (Dictionary.wordArray.get(mid).getWordTarget().compareTo(DictionaryManagement dict) == 0) {
                return mid;
            } else if (Dictionary.wordArray.get(mid).getWordTarget().compareTo(DictionaryManagement dict) >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
