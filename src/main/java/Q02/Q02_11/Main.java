package Q02.Q02_11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public int solution(int count, Scanner in) {
        int[][] map = new int[count][5];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = in.nextInt();
            }
        }

        int max = 0;
        int p = 0;
        for (int i = 0; i < count; i++) {
            Set<Integer> person = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int target = map[i][j];
                for (int k = 0; k < count; k++) {
                    if (k == i) {
                        continue;
                    }
                    if (map[k][j] == target) {
                        person.add(k);
                    }
                }
            }
            if (person.size() > max) {
                max = person.size();
                p = i;
            }
        }
        return p + 1;
    }
}
