package Q07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
    private static int n, m, answer = 0;
    private static List<List<Integer>> graph;
    private static int[] ch;

    public static void main(String[] args) {
        AdjacencyList main = new AdjacencyList();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        main.DFS(1);
        System.out.println(answer);
    }

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

}
