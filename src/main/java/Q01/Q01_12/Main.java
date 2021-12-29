package Q01.Q01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());
        String text = in.nextLine();
        System.out.println(main.solution(count, text));
    }

    public String solution(int count, String text) {
        // solution
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String temp = text.substring(i * 7, i * 7 + 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            sb.append((char)num);
        }
        return sb.toString();
        /*// my answer
        List<String> words = split(count, text);
        StringBuilder sb = new StringBuilder();
        //ver1
        // words.forEach(word -> sb.append(convert(word)));
        //ver2
        words.forEach(word -> sb.append(convert2(word)));
        return sb.toString();*/
    }

    private char convert(String word) {
        char[] chars = word.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                num += Math.pow(2, 6 - i);
            }
        }
        return (char)num;
    }

    private char convert2(String word) {
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return (char)Integer.parseInt(sb.toString(), 2);
    }

    private List<String> split(int count, String text) {
        List<String> words = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String c = text.substring(i * 7, i * 7 + 7);
            words.add(c);
        }
        return words;
    }
}
