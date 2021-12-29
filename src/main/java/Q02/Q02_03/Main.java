package Q02.Q02_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int count = Integer.parseInt(in.nextLine());
        String[] a = in.nextLine().split(" ");
        String[] b = in.nextLine().split(" ");
        main.solution(count, a, b);
    }

    public void solution(int count, String[] a, String[] b) {
        for (int i = 0; i < count; i++) {
            int aValue = Integer.parseInt(a[i]);
            int bValue = Integer.parseInt(b[i]);
            int rs = aValue - bValue;
            if (rs == 1 || rs == -2) {
                System.out.println("A");
            } else if (rs == 2 || rs == -1) {
                System.out.println("B");
            } else if (rs == 0) {
                System.out.println("D");
            }
        }
    }
}
