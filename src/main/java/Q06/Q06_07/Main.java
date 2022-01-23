package Q06.Q06_07;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int[] ints : main.solution(s, in)) {
            for (int i = 0; i < ints.length; i++) {
                if (i == 1) {
                    System.out.println(ints[i]);
                } else {
                    System.out.print(ints[i]+" ");
                }
            }
        }
    }

    public int[][] solution(int s, Scanner in) {
        int[][] arr = new int[s][2];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        return insertSort(arr);
    }

    public int[][] insertSort(int[][] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
                if (num[j][0] < num[j - 1][0]) {
                    swap(num, j);
                } else if (num[j][0] == num[j - 1][0]) {
                    if (num[j][1] < num[j - 1][1]) {
                        swap(num, j);
                    }
                }
            }
        }
        return num;
    }

    private void swap(int[][] num, int j) {
        int x = num[j][0];
        int y = num[j][1];
        num[j][0] = num[j - 1][0];
        num[j][1] = num[j - 1][1];
        num[j - 1][0] = x;
        num[j - 1][1] = y;
    }
}
