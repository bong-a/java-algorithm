package Q05.Q05_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        int open = 0;

        for (String s : text.split("")) {
            if (open < 0) {
                return "NO";
            }
            if (s.equals("(")) {
                open++;
            } else if (s.equals(")")) {
                open--;
            }
        }
        if (open != 0) {
            return "NO";
        }
        return "YES";
    }
}
