package Q07.Q07_08;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(main.solution(n, m));
    }

    public int solution(int n, int m) {
        int answer = 0;
        int level = 0;
        int[] step = {1, -1, 5};
        Set<Integer> check = new HashSet<>();
        check.add(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (num == m) {
                    answer = level;
                    return answer;
                }
                for (int i1 : step) {
                    if (!check.contains(num + i1)) {
                        queue.offer(num + i1);
                        check.add(num + i1);
                    }
                }
            }
            level++;
        }
        return answer;
    }
}
