package programmers;

import java.util.Scanner;

public class Q_43238 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] times = new int[m];
        for (int i = 0; i < m; i++) {
            times[i] = in.nextInt();
        }
        Q_43238 q = new Q_43238();
        long answer = q.solution(n, times);
        System.out.println(answer);
    }

    public long solution(int n, int[] times) {
        int max = Integer.MAX_VALUE;
        int maxTime = 0;
        for (int i = 0; i < times.length; i++) {
            maxTime = Math.max(maxTime, times[i] * n);
        }

        int pl = 0;
        int pr = maxTime;
        int mid = 0;
        while (pl <= pr) {
            int sum = 0;
            mid = (pl + pr) / 2;
            // System.out.println("mid = " + mid);
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }
            // System.out.println("sum = " + sum);
            if (sum == n) {
                max = Math.min(max,mid);
            } else if (sum > n) {
                pl = mid + 1;
                // System.out.println("pr :" + pr);
            } else {
                pr = mid - 1;
                // System.out.println("pl :" + pr);

            }

        }

        return max;
    }
}
