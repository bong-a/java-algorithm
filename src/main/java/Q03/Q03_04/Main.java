package Q03.Q03_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();

        int[] aList = new int[n];
        for (int i = 0; i < n; i++) {
            aList[i] = in.nextInt();
        }
        System.out.println(main.solution(aList, sum));
    }

    private int solution(int[] a, int sum) {
        int total = 0;
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < a.length) {
            if (total > sum) {
                total -= a[p1++];
            } else {
                total += a[p2++];
            }
            if (total == sum) {
                count++;
            }
        }
        return count;
    }

}
