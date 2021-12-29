package Q02.Q02_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = in.nextInt();
        System.out.println(main.solution(count));
    }

    public int solution(int count) {
        //solution
        int answer = 0;
        int[] num = new int[count + 1];
        for (int i = 2; i <= count; i++) {
            if (num[i] == 0) {
                answer++;
                for (int j = i; j <= count; j = j + i) {
                    num[j] = 1;
                }
            }
        }
        return answer;
        /*
        // my answer - Time Limit Exceeded
        List<Integer> number = IntStream.rangeClosed(1, count).boxed().collect(Collectors.toList());
        int rs = 0;
        for (int i = 0; i < count; i++) {
            int num = i + 1;
            if (num > 1) {
                int cnt = 0;
                for (Integer integer : number.subList(1, i)) {
                    if (num % integer == 0) {
                        cnt++;
                    }
                    if (cnt > 0) {
                        break;
                    }
                }
                if (cnt == 0) {
                    rs++;
                }
            }
        }
        return rs;*/
    }
}
