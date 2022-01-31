package Q08.Q08_05;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int arrLen;
    static int n;
    static int sum;
    static int answer = Integer.MAX_VALUE;
    static int[] coinType;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        coinType = new int[n];
        for (int i = 0; i < coinType.length; i++) {
            coinType[i] = in.nextInt();
        }
        sum = in.nextInt();
        arrLen = 0;
        for (int i : coinType) {
            arrLen += (sum / i);
        }
        arr = new int[arrLen];
        // main.DFS(0);
        main.DFS2(0, 0);
        System.out.println(answer);
    }

    // solution
    private void DFS2(int cnt, int s) {
        if (s > sum || cnt > answer) {
            return;
        } else if (s == sum) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = coinType.length-1; i >=0; i--) {
                DFS2(cnt + 1, s + coinType[i]);
            }
        }
    }
    /*
    my answer - time over
    private void DFS(int num) {
        int numSum = 0;
        int cnt = 0;
        for (int i : arr) {
            numSum += i;
            if (i > 0) {
                cnt++;
            }
        }
        if (numSum > sum || cnt > answer) {
            return;
        } else if (numSum == sum) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = coinType.length - 1; i >= 0; i--) {
                arr[num] = coinType[i];
                DFS(num + 1);
                arr[num] = 0;
            }
        }
    }*/
}
