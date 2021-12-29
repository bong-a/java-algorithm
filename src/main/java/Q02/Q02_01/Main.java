package Q02.Q02_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public String solution(int count, Scanner in) {
        int previous = 0;
        int current = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                previous = current;
            }
            current = in.nextInt();
            if (current > previous) {
                sb.append(current).append(" ");
            }
        }
        return sb.toString();
    }
}
