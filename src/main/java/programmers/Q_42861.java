package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_42861 {
    static int[] unf;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        Q_42861 main = new Q_42861();
        int a = main.solution(n, costs);
        System.out.println(a);
    }

    public int solution(int n, int[][] costs) {
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        List<Edge> arr = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            arr.add(new Edge(cost[0], cost[1], cost[2]));
        }
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;
        for (Edge edge : arr) {
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            // System.out.println(edge.v1 + "->" + edge.v2);
            // System.out.println("fv1=" + fv1 + ",fv2=" + fv2);
            if (fv1 != fv2) {
                answer += edge.cost;
                cnt++;
                union(edge.v1, edge.v2);
            }
            if (cnt == (n - 1)) {
                break;
            }
        }
        // System.out.println(answer);
        return answer;
    }

    public static int find(int v) {
        if (v == unf[v])
            return v;
        else
            return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
            //System.out.println("unf[" + fa + "]=" + fb);
        }
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
