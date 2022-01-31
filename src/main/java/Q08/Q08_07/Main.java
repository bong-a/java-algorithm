package Q08.Q08_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, Integer> combination;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        combination = new HashMap<>();
        // System.out.println(fibonacciNumber.DFS2(5));
        main.DFS(n, r);
        System.out.print(combination.get(n + "C" + r));
    }

    public int DFS(int n, int r) {
        if (combination.containsKey(n + "C" + r) && combination.get(n + "C" + r) > 0) {
            return combination.get(n + "C" + r);
        }
        if(n==r){
            combination.put(n + "C" + r, 1);
            return 1;
        }
        if (r == 0) {
            combination.put(n + "C" + r, 0);
            return 0;
        }
        if (r == 1) {
            combination.put(n + "C" + r, n);
            return n;
        }
        if (n == 3) {
            if (r == 3 || r == 0) {
                combination.put(n + "C" + r, 1);
                return 1;
            } else {
                combination.put(n + "C" + r, 3);
                return 3;
            }
        } else {
            int num = DFS(n - 1, r - 1) + DFS(n - 1, r);
            // System.out.println(n + "C" + r + ":" + num);
            combination.put(n + "C" + r, num);
            return num;
        }
    }
}
