package Q01.Q01_01;

import java.util.Scanner;

public class Main {

    public int solution(String text, char find) {
        String processedText = text.toLowerCase();
        char processedChar = Character.toLowerCase(find);
        int count = 0;
        for (char character : processedText.toCharArray()) {
            if (character == processedChar) {
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        String text = scanner.next();
        char find = scanner.next().charAt(0);
        System.out.println(main.solution(text, find));
    }
}
