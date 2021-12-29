package Q03.Q03_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        int count = in.nextInt();

        int[] aList = new int[day];
        for (int i = 0; i < day; i++) {
            aList[i] = in.nextInt();
        }
        System.out.println(main.solution(aList, count));
    }

    private int solution(int[] a, int count) {
        //solution
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += a[i];
        }
        int max = sum;
        for (int i = count; i < a.length; i++) {
            sum -= a[i - count];
            sum += a[i];
            max = Math.max(max, sum);
        }
        return max;
        //my answer time limit exceeded
        /*int max = 0;
        for (int i = 0; i <= a.length - count; i++) {
            int sum = 0;
            for (int j = 0; j < count; j++) {
                sum += a[i+j];
            }
            max = Math.max(max, sum);
        }
        return max;*/
    }

}
