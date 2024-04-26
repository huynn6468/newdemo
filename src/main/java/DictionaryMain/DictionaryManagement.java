package DictionaryMain;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;

public class DictionaryManagement extends Dictionary {
    public DictionaryManagement() {
        super();
    }
    private Scanner sc = new Scanner(System.in);
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

    public int dictionarySearcherBinary (String target) {
        int l= 0;
        int r = this.wordArray.size() -1;
        while (l <= r) {
            int mid = r + (l - r) /2;
            if (target.compareTo(this.wordArray.get(mid).getWordTarget()) == 0) {
                return mid;
            } else if (target.compareTo(this.wordArray.get(mid).getWordTarget()) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public String dictionaryLookup(String target) {
        if (target != null) {
            return this.wordArray.get(dictionarySearcherBinary(target)).getWordExplain();
        } else {
            return "";
        }
    }
    public void showAllWords() {
        System.out.println("Danh sách tất cả các từ đang có trong từ điển: ");
        System.out.println("No  | English           | Vietnamese");

        for (int i = 0; i < Dictionary.wordArray.size(); i++) {
            Word word = Dictionary.wordArray.get(i);
            System.out.printf("%-4d| %-18s| %s%n", (i + 1), word.getWordTarget(), word.getWordExplain());
        }
    }
    public void insertFromFile() {
        try {
            File wordFile = new File("src/main/resources/File/dictionary.txt");
            Scanner fileReader = new Scanner(wordFile);
            while (fileReader.hasNextLine()) {
                String content = fileReader.nextLine();
                content.trim();
                String[] postSplit = content.split("\\t");
                Word w = new Word(postSplit[0], postSplit[1]);
                this.wordArray.add(w);
            }
                fileReader.close();
                Collections.sort(this.wordArray);
            } catch (FileNotFoundException e) {
                System.out.println("Lỗi, không tìm thấy file.");
            }
        }

    public void editWord() {
        System.out.println("Chọn thao tác: ");
        System.out.println("1.Xóa từ");
        System.out.println("2.Thêm từ");
        int key = sc.nextInt();
        sc.nextLine();
        if (key == 1) {
            System.out.println("Nhập từ cần xóa: ");
            String dellWord = sc.next();
            if (this.dictionarySearcherBinary(dellWord) != -1) {
                this.wordArray.remove(this.dictionarySearcherBinary(dellWord));
            } else {
                System.out.println("Không tìm thấy từ cần xóa");
            }
        } else if (key == 2) {
            System.out.println("Nhập từ cần sửa: ");
            String editWord = sc.nextLine();
            if (this.dictionarySearcherBinary(editWord) != -1) {
                System.out.println("Sửa lại nghĩa: ");
                String exWord = sc.nextLine();
                System.out.println("Thêm từ thành công");
                this.wordArray.get(dictionarySearcherBinary(editWord)).setWordExplain(exWord);
            } else {
                System.out.println("Không tìm thấy từ");
            }
        }
    }

    public void dictionaryExportToFile() {
        Path filePath = Path.of("src/main/resources/File/dictionary.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (int i = 0; i < wordArray.size(); i++) {
                writer.write(wordArray.get(i).getWordTarget() + "    " + wordArray.get(i).getWordExplain());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
