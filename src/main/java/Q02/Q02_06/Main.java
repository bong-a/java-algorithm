package Q02.Q02_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(in.next());
        }
        System.out.println(main.solution(numbers));
    }

    public String solution(List<String> numbers) {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            int invertNum = invert(number);
            int cnt = 0;
            for (Integer i : IntStream.rangeClosed(1, invertNum).boxed().collect(Collectors.toList())) {
                if (invertNum % i == 0) {
                    cnt++;
                }
                if (cnt > 2) {
                    break;
                }
            }
            if (cnt == 2) {
                sb.append(invertNum).append(" ");
            }
        }
        return sb.toString();
    }

    private int invert(String number) {
        char[] chars = number.toCharArray();
        int last = chars.length - 1;
        for (int i = 0; i < (chars.length / 2); i++) {
            char temp = chars[i];
            chars[i] = chars[last-i];
            chars[last-i] = temp;
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
