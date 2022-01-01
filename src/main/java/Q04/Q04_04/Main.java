package Q04.Q04_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String t1 = in.next();
        String t2 = in.next();
        System.out.println(main.solution(t1, t2));
    }

    public int solution(String t1, String t2) {
        Map<String, Integer> target = takeAnagram(t2);
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        String[] str = t1.split("");
        Map<String, Integer> s = new HashMap<>();
        while (p2 < str.length) {
            String j = str[p2];
            if (s.containsKey(j)) {
                s.computeIfPresent(j, (k, v) -> v + 1);
            } else {
                s.put(j, 1);
            }
            if (p2 >= t2.length()) {
                String del = str[p1];
                if (s.containsKey(del)) {
                    s.computeIfPresent(del, (key, v) -> v - 1);
                    if (s.get(del) == 0) {
                        s.remove(del, 0);
                    }
                }
                p1++;
            }
            if (p2 >= t2.length() - 1) {

                boolean rs = true;
                for (Map.Entry<String, Integer> entry : s.entrySet()) {
                    String key = entry.getKey();
                    if (!target.containsKey(key) || target.get(key) != entry.getValue()) {
                        rs = false;
                        break;
                    }
                }

                if (rs) {
                    sum++;
                }
            }

            p2++;

        }

        return sum;
    }

    private Map<String, Integer> takeAnagram(String t2) {
        Map<String, Integer> target = new HashMap<>();
        for (String s : t2.split("")) {
            if (target.containsKey(s)) {
                target.computeIfPresent(s, (k, v) -> v + 1);
            } else {
                target.put(s, 1);
            }
        }
        return target;
    }
}
