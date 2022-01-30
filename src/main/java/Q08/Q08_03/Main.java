package Q08.Q08_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int maxTime;
    static int n;
    static int max;
    static int score;
    static int[] index;
    static List<List<Integer>> arr;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        maxTime = in.nextInt();

        index = new int[n + 1];
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(in.nextInt(), in.nextInt()));
        }
        main.DFS(1);
        System.out.println(score);
    }

    private void DFS(int m) {
        if (m == n + 1) {
            int sum = 0;
            int scoreSum = 0;
            for (int i = 1; i < index.length; i++) {
                if (index[i] == 1) {
                    List<Integer> list = arr.get(i - 1);
                    scoreSum += list.get(0);
                    sum += list.get(1);
                }
            }
            if (maxTime >= sum && max <= sum && scoreSum > score) {
                max = sum;
                score = scoreSum;
            }
        } else {
            index[m] = 1;
            DFS(m + 1);
            index[m] = 0;
            DFS(m + 1);
        }
    }
}
