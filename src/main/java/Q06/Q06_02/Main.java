package Q06.Q06_02;

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
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        return num;
    }
}
