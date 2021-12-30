package Q03.Q03_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(main.solution(n, k, arr));
    }

    private int solution(int n, int k, int[] arr) {
        int answer = 0;
        int count = 0;
        int zeroCount = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < arr.length) {
            if (arr[p2] == 0) {
                zeroCount++;
            }

            if (zeroCount >= k + 1) {
                answer = Math.max(answer, count);
                if (arr[p1] == 0) {
                    zeroCount--;
                }
                p1++;
            } else {
                count++;
            }
            p2++;
        }

        return answer;
    }

}
