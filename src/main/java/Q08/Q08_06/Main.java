package Q08.Q08_06;

import java.util.Scanner;

public class Main {
    static int[] pm;
    static int n, m;
    static int[] arr;
    static int[] ch;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
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

            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[num] = arr[i];
                    DFS(num + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
