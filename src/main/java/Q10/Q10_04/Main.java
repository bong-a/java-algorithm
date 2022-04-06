package Q10.Q10_04;

import java.util.Scanner;

public class Main {
    private static int[] dy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][3];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        Main main = new Main();
        int rs = main.solution(arr);
        System.out.println(rs);

    }

    private int solution(int[][] arr) {
        quickSort(arr, 0, arr.length-1);
        int answer = 0;
        dy[0] = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][2] < arr[i][2] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + arr[i][1];
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public void quickSort(int[][] arr, int s, int e) {
        int pl = s;
        int pr = e;
        int pivot = (pl + pr) / 2;
        int x = arr[pivot][0];

        do {
            //find arr[pl]>x index
            while (arr[pl][0] < x) {
                pl++;
            }
            //find pr<x index
            while (arr[pr][0] > x) {
                pr--;
            }
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        //왼쪽
        if (s < pr) {
            quickSort(arr, s, pr);
        }
        if (pl < e) {
            quickSort(arr, pl, e);
        }
    }

    private void swap(int[][] arr, int idx1, int idx2) {
        int[] temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
