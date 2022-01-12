package Q06.Q06_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        for (int i : main.solution(s, n, in)) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int s, int n, Scanner in) {

        // my answer
        int[] arr = new int[s];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            //find in arr
            int p = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num) {
                    p = j;
                }
            }
            if (p == -1) {
                //not found
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            } else {
                // found
                for (int j = p; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[0] = num;
        }
        return arr;
    }
}
