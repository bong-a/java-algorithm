package Q05.Q05_04;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public int solution(String text) {
        String[] str = text.split("");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String s : str) {
            if (Character.isDigit(s.toCharArray()[0])) {
                queue.offerFirst(Integer.parseInt(s));
            } else {
                int n = queue.pollFirst();
                int n2 = queue.pollFirst();
                int num = calculate(s, n, n2);
                queue.offerFirst(num);
            }
        }
        return queue.pollFirst();
    }

    private int calculate(String s, int n, int n2) {
        switch (s) {
            case "+":
                return (n2 + n);
            case "-":
                return (n2 - n);
            case "*":
                return (n2 * n);
            case "/":
                return (n2 / n);
            default:
                break;

        }
        return 0;
    }
}
