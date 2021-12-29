package Q03.Q03_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] aList = new int[count];
        for (int i = 0; i < count; i++) {
            aList[i] = in.nextInt();
        }
        int bCount = in.nextInt();
        int[] bList = new int[bCount];
        for (int i = 0; i < bCount; i++) {
            bList[i] = in.nextInt();
        }
        for (int i : main.solution(aList, bList)) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] a, int[] b) {
        int[] total = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            total[i] = a[i];
        }
        int len = a.length;
        for (int i = 0; i < b.length; i++) {
            total[len + i] = b[i];
        }

        for (int i = 0; i < total.length; i++) {
            int min = total[i];
            int minIdx = i;
            for (int j = i + 1; j < total.length; j++) {
                if (total[j] < min) {
                    min = total[j];
                    minIdx = j;
                }
            }
            swap(total, i, minIdx);
        }
        return total;
    }

    private void swap(int[] total, int i, int minIdx) {
        int temp = total[i];
        total[i] = total[minIdx];
        total[minIdx] = temp;
    }
}
