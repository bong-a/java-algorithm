package Q06.Q06_08;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int key = in.nextInt();
        System.out.println(main.solution(s, key, in));
    }

    public int solution(int s, int key, Scanner in) {
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int mIdx = (end + start) / 2;
        while (end - start >= 0) {
            if (arr[mIdx] < key) {
                start = mIdx + 1;
            } else if (arr[mIdx] > key) {
                end = mIdx - 1;
            } else if (arr[mIdx] == key) {
                return mIdx + 1;
            }
            mIdx = (end + start) / 2;
        }
        return -1;
    }
}
