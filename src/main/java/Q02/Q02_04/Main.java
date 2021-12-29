package Q02.Q02_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count));
    }

    public String solution(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ").append(1).append(" ");
        int prev = 1;
        int curr = 1;
        for (int i = 2; i < count; i++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
            sb.append(curr).append(" ");
        }
        return sb.toString();
    }
}
