package Q06.Q06_06;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        main.solution(s, in);
    }

    public void solution(int s, Scanner in) {
        int[] arr = new int[s];
        int[] temp = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = in.nextInt();
            temp[i] = arr[i];
        }
        temp = insertSort(temp);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != temp[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }

    public int[] insertSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0; j--) {
                if (num[j] < num[j - 1]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                }
            }
        }
        return num;
    }
}
