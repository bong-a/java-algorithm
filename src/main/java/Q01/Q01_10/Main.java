package Q01.Q01_10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String word = in.next();
        char targetChar = in.next().charAt(0);
        for (int i : main.solution(word, targetChar)) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String word, char targetChar) {
        int position = 1000;
        int[] rs = new int[word.length()];
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                position = 0;
            } else {
                position++;
            }
            rs[i] = position;
        }
        position = 1000;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == targetChar) {
                position = 0;
            } else {
                position++;
            }
            rs[i] = Math.min(rs[i], position);
        }
        return rs;
    }
}
