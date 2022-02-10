package Q09.Q09_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] unf;

    public static int find(int v) {
        if (v == unf[v])
            return v;
        else
            return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb)
            unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        unf = new int[n + 1];
        List<Edge> arr = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            arr.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;
        for (Edge edge : arr) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if (fv1 != fv2) {
                answer += edge.cost;
                cnt++;
                union(edge.v1, edge.v2);
            }
            if (cnt == (n - 1)) {
                break;
            }
        }
        System.out.println(answer);

    }

}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.cost - edge.cost;
    }
}