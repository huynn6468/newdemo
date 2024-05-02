package DictionaryMain;

import java.io.*;
import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {
    private static final Scanner sc = new Scanner(System.in);

    public static void dictionaryBasic(DictionaryManagement dict) {
        dict.insertFromCommandline();
        System.out.println("\n");
        dict.showAllWords();
        System.out.println("\n");
    }

    public void dictionaryAdvanced(DictionaryManagement dict) {

        dict.insertFromFile();
        System.out.println("\n");
        dict.showAllWords();
        System.out.println("\n");
        System.out.println("Nhập từ tiếng Anh : ");
        String target = sc.nextLine();
        System.out.println(dict.dictionaryLookup(target));
        System.out.println("\n");
        dict.editWord();
        System.out.println("\n");
        dict.dictionaryExportToFile();
        System.out.println("\n");
    }

     public static void dictionarySearcher(DictionaryManagement dict) {
        System.out.print("Nhập từ muốn tìm: ");
        String search = sc.nextLine();
        int i = 0;
        if (i < dict.getWordArray().size()) {
            if (!dict.getWordArray().get(i).getWordTarget().contains(search)) {
                System.out.println("Không tìm thấy từ !");
            } else {
                System.out.println("English           | Vietnamese");
                System.out.println(dict.getWordArray().get(i).getWordTarget() + "           | "
                        + dict.getWordArray().get(i).getWordExplain());
            }
            i++;
        }
    }

}

