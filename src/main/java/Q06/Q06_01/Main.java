package Q06.Q06_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = in.nextInt();
        }
        for (int i : main.solution(array)) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int min = num[i];
            int idx = i;
            for (int j = i + 1; j < num.length; j++) {
                int n = num[j];
                if (min > n) {
                    min = n;
                    idx = j;
                }
            }
            int temp = num[i];
            num[i] = num[idx];
            num[idx] = temp;
        }
        return num;
    }
}
