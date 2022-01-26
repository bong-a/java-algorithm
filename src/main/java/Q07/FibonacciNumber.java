package Q07;

public class FibonacciNumber {
    private static int[] fibo;

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int n = 45;
        fibo = new int[n + 1];
        // System.out.println(fibonacciNumber.DFS2(5));
        fibonacciNumber.DFS3(n);
        for (int i = 0; i < n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int DFS3(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            fibo[n] = 1;
            return 1;
        } else if (n == 2) {
            fibo[n] = 1;
            return 1;
        } else {
            fibo[n] = DFS3(n - 2) + DFS3(n - 1);
            return fibo[n];
        }
    }

    public void DFS2(int n) {
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                fibo[i] = 1;
            } else {
                fibo[i] = fibo[i - 2] + fibo[i - 1];
            }
        }
    }

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return DFS(n - 2) + DFS(n - 1);
        }
    }

}
