package Q05.Q05_07;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String m = in.nextLine();
        System.out.println(main.solution(n, m));
    }

    public String solution(String n, String m) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String s : n.split("")) {
            queue.offerLast(s);
        }
        for (String s : m.split("")) {
            String target = queue.getFirst();
            if (target.equals(s)) {
                queue.pollFirst();
            }
            if (queue.isEmpty()) {
                return "YES";
            }
        }
        return "NO";
    }
}
