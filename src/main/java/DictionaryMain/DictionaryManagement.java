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
    private final Scanner scanner = new Scanner(System.in);

    public void DictionaryManagement() {
        Map<String, String> dictionary = new HashMap<>();
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
        Collections.sort(this.wordArray);
    }

    public int dictionarySearcherBinary (String target) {
        int l= 0;
        int r = wordArray.size() -1;
        while (l <= r) {
            int mid = r + (l - r) /2;
            if (target.compareTo(wordArray.get(mid).getWordTarget()) == 0) {
                return mid;
            } else if (target.compareTo(wordArray.get(mid).getWordTarget()) > 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public String dictionaryLookup(String target) {
        if (target != null) {
            String wordExplain = wordArray.get(dictionarySearcherBinary(target)).getWordExplain();
            return wordExplain;
        } else {
            return "";
        }
    }
    public void showAllWords() {
        System.out.println("Danh sách tất cả các từ đang có trong từ điển: ");
        System.out.println("No  | English          | Vietnamese");

        aa: for (int i = 0; i < Dictionary.wordArray.size(); i++) {
            Word word = Dictionary.wordArray.get(i);
            System.out.println((i + 1) + "  | " + this.wordArray.get(i).getWordTarget() + "           | "
                    + this.wordArray.get(i).getWordExplain());
        }
    }

    public void insertFromFile() {
        try {
            File wordFile = new File("src/main/resources/File/dictionary.txt");
            Scanner fileReader = new Scanner(wordFile);
            String English = new String();
            String Vietnamese = new String();
            StringBuilder line = new StringBuilder();
            String temp = "";
            while (fileReader.hasNextLine()) {
                temp = fileReader.nextLine() + "\n";
                line.append(temp);
            }
            String[] eachWord = line.toString().split("@");
            for (int i = 1; i < eachWord.length; i++) {
                if (eachWord[i].contains("/")) {
                    int k = eachWord[i].indexOf("/");
                    English = eachWord[i].substring(0, k - 1);
                    Vietnamese = eachWord[i].substring(k, eachWord[i].length() - 1);
                    Word w = new Word(English, Vietnamese);
                    this.wordArray.add(w);
                }
            }

            Collections.sort(this.wordArray);
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi! Không tìm thấy file.");
            e.printStackTrace();
        }
    }

    public void editWord() {
        System.out.println("Chọn thao tác: ");
        System.out.println("1.Xóa từ");
        System.out.println("2.Thêm từ");
        System.out.println("3.Sửa từ");
        int key = scanner.nextInt();
        scanner.nextLine();
        if (key == 1) {
            System.out.println("Nhập từ cần xóa: ");
            String dellWord = scanner.next();
            int index = dictionarySearcherBinary(dellWord);
            if (index != -1) {
                wordArray.remove(index);
                System.out.println("Xóa từ thành công.");
            } else {
                System.out.println("Không tìm thấy từ cần xóa.");
            }
        } else if (key == 2) {
            System.out.println("Nhập từ cần thêm: ");
            String newWord = scanner.nextLine();
            String editWord = scanner.nextLine();
            int index = dictionarySearcherBinary(newWord);
            if (index != -1) {
                System.out.println("Nhập nghĩa của từ: ");
                String exWord = scanner.nextLine();
                wordArray.get(index).setWordExplain(exWord);
                System.out.println("Thêm từ thành công.");
                this.wordArray.get(dictionarySearcherBinary(editWord)).setWordExplain(exWord);
            } else {
                System.out.println("Từ đã tồn tại.");
            }
        } else if (key == 3) {
            System.out.print("Nhập từ muốn sửa: ");
            String editWord = scanner.nextLine();
            int index = dictionarySearcherBinary(editWord);
            if (index == -1) {
                System.out.print("Nhập nghĩa của từ: ");
                String exWord = scanner.nextLine();
                wordArray.get(index).setWordExplain(exWord);
                System.out.println("Sửa từ thành công.");
                this.wordArray.get(dictionarySearcherBinary(editWord)).setWordExplain(exWord);
            } else {
                System.out.println("Không tìm thấy từ!");
            }
        }
    }

    /**    private final static String FILE_URL = "D://oop//noteenglíh.txt";
     *
    public void addFile() {
        try {
            File file = new File("src/main/resources/File/dictionary.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(FILE_URL);
            bw.newLine();
            bw.close();
        } catch ( IOException e) {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        }
    }
*/

    public static void dictionaryExportToFile() {

        Path filePath = Path.of("src/main/resources/File/dictionary.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (int i = 0; i < wordArray.size(); i++) {
                writer.write(wordArray.get(i).getWordTarget() + "    " + wordArray.get(i).getWordExplain());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi!");
            e.printStackTrace();
        }
    }
/**
    private final static String FILE_URL = "D://oop//noteenglíh.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(FILE_URL);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
     */
}
