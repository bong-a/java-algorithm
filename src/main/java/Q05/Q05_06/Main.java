package Q05.Q05_06;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(main.solution(n, k));
    }

    public int solution(int n, int k) {
        List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());

        int idx = 1;
        int curr = 0;
        int cnt = list.size();
        while (cnt > 1) {
            if (idx % k == 0) {
                list.remove(curr--);
                cnt--;
            }
            if (curr == (list.size() - 1)) {
                curr = 0;
            } else {
                curr++;
            }
            idx++;
        }
        return list.get(0);
    }
}
