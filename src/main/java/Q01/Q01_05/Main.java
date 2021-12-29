package Q01.Q01_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        int left = 0;
        int right = text.length() - 1;
        char[] chars = text.toCharArray();
        while (left < right) {
            if (!Character.isAlphabetic(chars[left])) {
                left++;
            } else if (!Character.isAlphabetic(chars[right])) {
                right--;
            } else {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
