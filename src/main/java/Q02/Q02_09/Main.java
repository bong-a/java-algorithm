package Q02.Q02_09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count, in));
    }

    public int solution(int count, Scanner in) {
        int[] rowSum = new int[count];
        int[] colSum = new int[count];
        int[] xSum = new int[count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                int n = in.nextInt();

                rowSum[i] += n;
                colSum[j] += n;
                if (i == j) {
                    xSum[i] += n;
                }
            }
        }
        return Stream.of(rowSum, colSum, xSum)
            .map(s -> Arrays.stream(s).boxed().max(Comparator.comparing(a -> a)).orElse(0))
            .max(Comparator.comparingInt(a -> a))
            .orElse(0);
    }
}
