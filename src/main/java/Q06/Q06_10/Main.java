package Q06.Q06_10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(main.solution(n, m, arr));
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[arr.length - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1;
        int endPos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - endPos >= capacity) {
                cnt++;
                endPos = arr[i];
            }
        }
        return cnt;
    }
}
