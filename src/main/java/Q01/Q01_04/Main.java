package Q01.Q01_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.next());
        Main main = new Main();
        List<String> words = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            String word = scanner.next();
            words.add(word);
        }
        for (String word : words) {
            System.out.println(main.solution(word));
        }
    }

    public String solution(String word) {
        StringBuilder sb = new StringBuilder();
        char[] words = word.toCharArray();
        for (int i = word.length()-1; i >= 0; i--) {
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
