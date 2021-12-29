package Q02.Q02_08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            num.add(in.nextInt());
        }
        System.out.println(main.solution(num));
    }

    public String solution(List<Integer> number) {
        int[] ranks = new int[number.size()];
        for (int i = 0; i < number.size(); i++) {
            int num = number.get(i);
            int rank = 1;
            for (int j = 0; j < number.size(); j++) {
                if (number.get(j) > num) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }
        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank).append(" ");
        }
        return sb.toString();
    }
}
