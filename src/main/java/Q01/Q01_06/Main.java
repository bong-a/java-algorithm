package Q01.Q01_06;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        char[] chars = text.toCharArray();
        Set<String> dup = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int point = 0; point < text.length(); point++) {
            char target = chars[point];
            if (dup.contains(String.valueOf(target))) {
                continue;
            }
            dup.add(String.valueOf(target));
            sb.append(target);
        }
        return sb.toString();
    }
}
