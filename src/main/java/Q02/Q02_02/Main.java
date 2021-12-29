package Q02.Q02_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public int solution(int count, Scanner in) {
        int max = 0;
        int answer = 0;
        for (int i = 0; i < count; i++) {
            int height = in.nextInt();
            if (height > max) {
                max = height;
                answer++;
            }
        }
        return answer;
    }
}
