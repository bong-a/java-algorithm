package wanted.Q02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] home = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            home[i] = in.nextInt();
        }
        int[][] arr = new int[n - 1][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        int[][] quiz = new int[q][2];
        for (int i = 0; i < quiz.length; i++) {
            quiz[i][0] = in.nextInt();
            quiz[i][1] = in.nextInt();
        }
        Main main = new Main();
        main.solution(home, arr, quiz);
    }

    private void solution(int[] home, int[][] arr, int[][] quiz) {
        for (int i = 0; i < quiz.length; i++) {
            int[] check = new int[home.length];
            int start = quiz[i][0];
            int end = quiz[i][1];
            if (start == end) {
                System.out.println(home[start]);
                continue;
            }
            String result = "" + home[start];
            check[start] = 1;
            DFS(start, end, check, home, arr, result);
        }
    }

    private void DFS(int target, int end, int[] check, int[] home, int[][] arr, String result) {
        if (target == end) {
            System.out.println((int)(Double.parseDouble(result) % 1000000007));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] == target && check[arr[i][1]] == 0) {
                    check[arr[i][1]] = 1;
                    DFS(arr[i][1], end, check, home, arr, result + home[arr[i][1]]);
                    check[arr[i][1]] = 0;
                } else if (arr[i][1] == target && check[arr[i][0]] == 0) {
                    check[arr[i][0]] = 1;
                    DFS(arr[i][0], end, check, home, arr, result + home[arr[i][0]]);
                    check[arr[i][0]] = 0;
                }
            }
        }
    }
}
