package Q01.Q01_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String text = scanner.next();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append((char)(c + 32));
            } else {
                sb.append((char)(c - 32));
            }
            /*if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }*/
        }
        return sb.toString();
    }
}
