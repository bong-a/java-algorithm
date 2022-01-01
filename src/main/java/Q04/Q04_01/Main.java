package Q04.Q04_01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String text = in.next();
        System.out.println(main.solution(count, text));
    }

    public String solution(int num, String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] chars = text.split("");
        for (int i = 0; i < 5; i++) {
            char c = (char)('A' + i);
            map.put(String.valueOf(c), 0);
        }

        for (int i = 0; i < chars.length; i++) {
            String s = chars[i];
            map.computeIfPresent(s, (k, v) -> v + 1);
        }
        return map.entrySet().stream()
            .min(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .orElse(null);
    }
}
