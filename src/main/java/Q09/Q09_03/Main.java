package Q09.Q09_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] time;
    static List<Time> arr;
    static int max;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        time = new int[72];
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Time(in.nextInt(), in.nextInt()));
        }
        main.solution(arr);
        System.out.println(max);
    }

    private void solution(List<Time> arr) {
        Collections.sort(arr);
        for (Time time1 : arr) {
            for (int i = time1.s; i < time1.e; i++) {
                time[i] = time[i] + 1;
                max = Math.max(max, time[i]);
            }
        }
    }
}

class Time implements Comparable<Time> {
    public int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.e == o.e)
            return this.s - o.s;
        else
            return this.e - o.e;
    }
}
