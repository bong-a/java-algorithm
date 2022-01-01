package Q04.Q04_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num.add(in.nextInt());
        }

        for (Integer integer : main.solution(n, k, num)) {
            System.out.print(integer+" ");
        }
    }

    public List<Integer> solution(int n, int k, List<Integer> num) {
        List<Integer> t = new ArrayList<>();
        int lt = 0;
        int rt = k;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int number = num.get(i);
            if (map.containsKey(number)) {
                map.computeIfPresent(number, (key, v) -> v + 1);
            } else {
                map.put(number, 1);
            }
        }
        t.add(map.size());
        while (rt < n) {
            int number = num.get(rt);
            if (map.containsKey(number)) {
                map.computeIfPresent(number, (key, v) -> v + 1);
            } else {
                map.put(number, 1);
            }
            int del = num.get(lt);
            if (map.containsKey(del)) {
                map.computeIfPresent(del, (key, v) -> v - 1);
                if (map.get(del) == 0) {
                    map.remove(del, 0);
                }
            }
            t.add(map.size());
            lt++;
            rt++;
        }
        return t;
    }
}
