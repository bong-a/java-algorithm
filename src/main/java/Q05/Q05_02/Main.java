package Q05.Q05_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        int cnt = 0;
        String[] str = text.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (cnt == 0 && !str[i].equals("(")) {
                sb.append(str[i]);
            }
            if (str[i].equals("(")) {
                cnt++;
            } else if (str[i].equals(")")) {
                cnt--;
            }
        }
        return sb.toString();
    }
}
