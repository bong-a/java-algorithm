package Q08.Q08_09;

import java.util.Scanner;

public class Main {
    static int[] ch;
    static int n, r;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        ch = new int[r];
        main.DFS(0, 0);

    }

    private void DFS(int L, int s) {
        if (L == r) {
            for (int i : ch) {
                System.out.print(i + " ");
            }
            System.out.println("");
        } else {
            for (int i = s; i <= n; i++) {
                ch[L] = i;
                DFS(L + 1, s + 1);
            }
        }
    }
}
