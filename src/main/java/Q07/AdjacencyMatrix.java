package Q07;

import java.util.Scanner;

public class AdjacencyMatrix {
    private static int n, m, answer = 0;
    private static int[][] graph;
    private static int[] ch;

    public static void main(String[] args) {
        AdjacencyMatrix main = new AdjacencyMatrix();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        main.DFS(1);
        System.out.println(answer);

    }

    public void DFS(int v) {

        if (v == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

}
