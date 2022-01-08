package Q05.Q05_05;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public int solution(String text) {
        int answer = 0;
        // solution
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                stack.push("(");
            } else if (text.charAt(i) == ')') {
                if (text.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        /*
        // my answer
        String[] str = text.split("");
        String prev = "";
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (String s : str) {
            if ("(".equals(s)) {
                map.put(index++, 1);
            } else if (")".equals(s)) {
                if ("(".equals(prev)) {
                    map.remove(--index, 1);
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        entry.setValue(entry.getValue() + 1);
                    }
                } else {
                    int cnt = map.get(--index);
                    answer += cnt;
                }
            }
            prev = s;
        }*/

        return answer;
    }
}
