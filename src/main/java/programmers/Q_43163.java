package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Q_43163 {
    public static void main(String[] args) {
        Q_43163 main = new Q_43163();
        String b = "hit";
        String t = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int a = main.bfs(b, t, words);
        System.out.println(a);
    }

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words) {
        int[] check = new int[words.length];
        int[] levels = new int[words.length];
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currIndex = 0;
            for (int i = 0; i < words.length; i++) {
                if (word.equals(words[i])) {
                    currIndex = i;
                    break;
                }
            }
            int currentWordLevel = levels[currIndex];
            if (word.equals(target)) {
                return levels[currIndex];
            } else {
                for (int i = 0; i < words.length; i++) {
                    String s = words[i];
                    int diff = 0;
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) != word.charAt(j)) {
                            diff++;
                        }
                    }
                    if (check[i] == 0 && diff == 1) {
                        check[i] = 1;
                        levels[i] = currentWordLevel + 1;
                        queue.add(s);
                    }
                }
            }
        }
        return 0;
    }
}
