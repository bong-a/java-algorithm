package Q08.Q08_04;

import java.util.Scanner;

public class Main {
    static int[] pm;
    static int n, m;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        main.DFS(0);

    }

    private void DFS(int num) {
        if (num == m) {
            for (int i : pm) {
                System.out.print(i + " ");
            }
            System.out.println("");
        } else {
            for (int i = 1; i <= n; i++) {
                pm[num] = i;
                DFS(num + 1);
            }
        }
    }
}
