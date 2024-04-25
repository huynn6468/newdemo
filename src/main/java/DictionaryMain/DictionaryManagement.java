package DictionaryMain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class DictionaryManagement {
    private Map<String, String> dictionary;

    public void DictionaryManament() {
        dictionary = new HashMap<>();
    }
    public void insertFromCommandline() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số từ muốn nhập: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<n; i++) {
            Word newWord = new Word();
            System.out.println("Nhập từ tiếng Anh: ");
            String tu = scanner.nextLine();
            newWord.setWordTarget(tu);
            System.out.println("Nhập nghĩa tiếng Việt: ");
            String nghiatu = scanner.nextLine();
            newWord.setWordExplain(nghiatu);
            Dictionary.wordArray.add(newWord);
        }
    }
    public void showAllWord() {
        int n = 1;
        System.out.format("%-5s %-20s %-20s\n", "No", "| English", "| Vietnamese");
        for (Word w : Dictionary.wordArray) {
            System.out.format("%-5s %-20s %-20s\n", n, w.getWordTarget(), w.getWordExplain());
            n++;
        }
    }
}
