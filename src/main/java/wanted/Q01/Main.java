package wanted.Q01;

import java.util.Scanner;

public class Main {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            c[i] = in.nextInt();
        }
        int[][][] p = new int[n + 1][n - 1][2];
        for (int i = 1; i <= n; i++) {
            int m = in.nextInt();
            int[][] temp = new int[n - 1][2];
            for (int j = 0; j < m; j++) {
                temp[j][0] = in.nextInt();
                temp[j][1] = in.nextInt();
            }
            p[i] = temp;
        }
        Main main = new Main();
        main.solution(c, p);
        System.out.println(min);
    }

    private void solution(int[] c, int[][][] p) {
        int[] check = new int[c.length];
        check[0] = 1;
        DFS(0, 0, check, c, p);
    }

    private void DFS(int L, int sum, int[] check, int[] c, int[][][] p) {
        if (L == c.length - 1) {
            boolean allVisit = true;
            for (int i = 1; i < check.length; i++) {
                if (check[i] == 0) {
                    allVisit = false;
                }
            }
            if (allVisit) {
                min = Math.min(min, sum);
            }
        } else {
            for (int i = 1; i < c.length; i++) {
                if (check[i] == 0) {
                    int[][] pArr = p[i];
                    int[] copy = new int[c.length];
                    for (int i1 = 0; i1 < pArr.length; i1++) {
                        int[] temp = pArr[i1];
                        int idx = temp[0];
                        int discount = temp[1];
                        if (check[idx] == 1 || idx == i || discount == 0)
                            continue;
                        copy[idx] = c[idx];
                        c[idx] = c[idx] - discount <= 0 ? 1 : c[idx] - discount;
                    }
                    check[i] = 1;
                    DFS(L + 1, sum + c[i], check, c, p);
                    check[i] = 0;
                    for (int j = 0; j < copy.length; j++) {
                        if (copy[j] != 0) {
                            c[j] = copy[j];
                        }
                    }
                }
            }
        }
    }
}