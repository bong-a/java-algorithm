package Q01.Q01_11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(main.solution(text));
    }

    public String solution(String text) {
        // solution
        StringBuilder answer = new StringBuilder();
        text = text + " ";
        int cnt = 1;
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                cnt++;
            } else {
                answer.append(text.charAt(i));
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt=1;
            }
        }
        return answer.toString();
        /*
        // my answer
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int target = 0;
        while (target < chars.length) {
            sb.append(chars[target]);
            int dup = 1;
            if (target == chars.length - 1) {
                break;
            }
            for (int j = target+1; j < chars.length; j++) {
                if (chars[target] == chars[j]) {
                    dup++;
                    if (j == chars.length - 1) {
                        target = process(sb, target, dup);
                        break;
                    }
                } else {
                    target = process(sb, target, dup);
                    break;
                }
            }
        }
        return sb.toString();*/
    }

    private int process(StringBuilder sb, int target, int dup) {
        if (dup > 1) {
            sb.append(dup);
        }
        target += dup;
        return target;
    }
}
