package Q02.Q02_07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public int solution(int count, Scanner in) {
        int score = 0;
        int prevScore = 0;
        for (int i = 0; i < count; i++) {
            int answer = in.nextInt();
            if (answer == 1) {
                prevScore++;
                score += prevScore;
            } else {
                prevScore = 0;
            }
        }
        return score;
    }
}
