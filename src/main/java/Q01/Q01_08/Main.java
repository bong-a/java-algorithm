package Q01.Q01_08;

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
        String filteredText = filterAlphabet(convertedText);
        // solution
        String reverseText = new StringBuilder(filteredText).reverse().toString();
        return filteredText.equals(reverseText) ? "YES" : "NO";
        /*
        // my answer
        int startPoint = 0;
        int endPont = filteredText.length() - 1;
        char[] chars = filteredText.toCharArray();
        while (startPoint < endPont) {
            if (chars[startPoint] == chars[endPont]) {
                startPoint++;
                endPont--;
                continue;
            } else {
                return "NO";
            }
        }
        return "YES";*/
    }

    private String filterAlphabet(String convertedText) {
        StringBuilder sb = new StringBuilder();
        for (char c : convertedText.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
