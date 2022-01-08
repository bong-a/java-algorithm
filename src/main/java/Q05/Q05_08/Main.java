package Q05.Q05_08;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int m = in.nextInt();
        System.out.println(main.solution(num, m, in));
    }

    public int solution(int num, int target, Scanner in) {
        ArrayDeque<List<Integer>> arrayDeque = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            int m = in.nextInt();
            arrayDeque.offerLast(Arrays.asList(i, m));
        }
        boolean next = true;
        while (next) {
            List<Integer> a = arrayDeque.pollFirst();
            if (arrayDeque.stream().noneMatch(s -> s.get(1) > a.get(1))) {
                cnt++;
                if (a.get(0) == target) {
                    next = false;
                }
            } else {
                arrayDeque.offerLast(a);
            }
        }

        return cnt;
    }
}
