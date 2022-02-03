package Q09.Q09_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(main.solution(n, in));
    }

    private int solution(int n, Scanner in) {
        List<Lecture> arr = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int d = in.nextInt();
            maxDay = Math.max(maxDay, d);
            arr.add(new Lecture(m, d));
        }
        Collections.sort(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int j = 0;
        for (int i = maxDay; i > 0; i--) {
            for (; j < n; j++) {
                if (arr.get(j).day < i) {
                    break;
                }
                queue.offer(arr.get(j).pay);
            }
            if (!queue.isEmpty()) {
                sum += queue.poll();
            }
        }

        return sum;
    }
}

class Lecture implements Comparable<Lecture> {
    int pay;
    int day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture lecture) {
        return lecture.day - this.day;
    }
}
