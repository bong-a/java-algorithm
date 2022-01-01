package Q04.Q04_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text1 = in.next();
        String text2 = in.next();
        System.out.println(main.solution(text1, text2));
    }

    public String solution(String text1, String text2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : text1.split("")) {
            if (map.containsKey(s)) {
                map.computeIfPresent(s, (k, v) -> v + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (String s : text2.split("")) {
            if (map.containsKey(s)) {
                map.computeIfPresent(s, (k, v) -> v - 1);
            } else {
                return "NO";
            }
        }
        return map.values().stream().allMatch(v -> v == 0) ? "YES" : "NO";
    }
}
