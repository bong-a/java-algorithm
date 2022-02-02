package Q09.Q09_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Time(x, y));
        }
        System.out.println(main.solution(arr, n));
    }

    private int solution(List<Time> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int endTime = 0;
        for (Time ob : arr) {
            if(ob.s >= endTime){
                cnt++;
                endTime = ob.e;
            }
        }
        return cnt;
    }
    /*static int[][] arr;
    static int n;
    static int cnt;
    static int[] time;
    static int[][] times;
    static int[] ch;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n][2];

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
                maxTime = Math.max(maxTime, arr[i][j]);
            }
        }
        time = new int[maxTime + 1];
        for (int i = 0; i < n; i++) {
            times = new int[n][2];
            main.DFS(i, 0);
        }

        System.out.println(cnt);
    }
    private void DFS(int L, int s) {
        if (L == n) {
            cnt = Math.max(cnt, s);
        } else {
            int[] t = arr[L];
            boolean exist = false;

            for (int i = 0; i < s; i++) {
                int[] ints = times[i];
                if (!((t[0] <= ints[0] && t[1] <= ints[0]) || t[0] >= ints[1])) {
                    exist = true;
                }
            }
            if (exist) {
                DFS(L + 1, s);
            } else {
                times[s] = t;
                DFS(L + 1, s + 1);
                times[s] = new int[2];
            }
        }
    }*/
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