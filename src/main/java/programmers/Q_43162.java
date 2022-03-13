package programmers;

import java.util.Scanner;

public class Q_43162 {
    public static void main(String[] args) {
        Q_43162 main = new Q_43162();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] computers = new int[n][n];
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                computers[i][j] = in.nextInt();
            }
        }
        int a = main.solution(n, computers);
        System.out.println(a);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(computers, isVisited, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, boolean[] isVisited, int startVertex) {
        for (int i = 0; i < computers[startVertex].length; i++) {
            if (!isVisited[i] && computers[startVertex][i] == 1) {
                isVisited[i] = true;
                dfs(computers, isVisited, i);
            }
        }
    }
}
