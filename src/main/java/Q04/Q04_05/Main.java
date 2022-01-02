package Q04.Q04_05;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        System.out.println(main.solution(k, num));
    }

    public int solution(int k, int[] num) {
        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int l = j + 1; l < num.length; l++) {
                    set.add(num[i] + num[j] + num[l]);
                }
            }
        }
        int cnt = 0;
        for (Integer integer : set) {
            cnt++;
            if (cnt == k) {
                return integer;
            }
        }
        return -1;
    }

}
