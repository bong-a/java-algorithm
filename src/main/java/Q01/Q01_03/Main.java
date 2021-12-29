package Q01.Q01_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String sentence = scanner.nextLine();
        System.out.println(main.solution(sentence));
    }

    public String solution(String sentence) {
        String[] words = sentence.split(" ");
        int longestLength = 0;
        String answer = words[0];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > longestLength) {
                answer = word;
                longestLength = word.length();
            }
        }
        return answer;
    }
}
