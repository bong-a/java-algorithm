package programmers;

import java.util.Scanner;

public class Q_43165 {
    private int cnt = 0;

    public static void main(String[] args) {
        Q_43165 main = new Q_43165();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int m = in.nextInt();
        int a = main.solution(numbers, m);
        System.out.println(a);
    }

    public int solution(int[] numbers, int target) {
       return dfs(0, 0, numbers, target);
        // return cnt;
    }

    private int dfs(int L, int sum, int[] numbers, int target) {
        if (numbers.length == L) {
            // System.out.println("sum : " + sum);
            if (target == sum) {
                return 1;
            }
            return 0;
        } else {
            //System.out.println("[+]" + L + ":" + (sum + numbers[L]));
            int a = dfs(L + 1, sum + numbers[L], numbers, target);
            //System.out.println("[-]" + L + ":" + (sum - numbers[L]));
            int b = dfs(L + 1, sum - numbers[L], numbers, target);
            return a + b;
        }
    }

}
