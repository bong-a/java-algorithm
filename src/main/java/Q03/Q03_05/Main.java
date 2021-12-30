package Q03.Q03_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(main.solution(n));
    }

    private int solution(int n) {
        int last = n / 2 + 1;
        int[] arr = new int[last];

        for (int i = 0; i < last; i++) {
            arr[i] = i + 1;
        }
        int total = 0;
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        do {
            if (total > n) {
                total -= arr[p1++];
            } else {
                total += arr[p2];
                p2++;
            }
            if (total == n) {
                count++;
            }
        } while (p2 < arr.length || p1 < arr.length - 2);
        return count;
    }

}
