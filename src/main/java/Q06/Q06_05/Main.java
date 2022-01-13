package Q06.Q06_05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        System.out.println(main.solution(s, in));
    }

    public String solution(int s, Scanner in) {
        int[] arr = new int[s];
        boolean isDup = false;
        for (int i = 0; i < s; i++) {
            int num = in.nextInt();
            for (int j = 0; j < i; j++) {
                if (arr[j] == num) {
                    isDup = true;
                    break;
                }
            }
            if (isDup) {
                break;
            } else {
                arr[i] = num;
            }
        }
        return isDup ? "D" : "U";

    }
}
