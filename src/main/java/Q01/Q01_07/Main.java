package Q01.Q01_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        String convertedText = text.toLowerCase();
        int startPoint = 0;
        int endPont = text.length() - 1;
        char[] chars = convertedText.toCharArray();
        while (startPoint < endPont) {
            if (chars[startPoint] == chars[endPont]) {
                startPoint++;
                endPont--;
                continue;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
