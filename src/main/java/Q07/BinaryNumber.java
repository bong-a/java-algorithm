package Q07;

public class BinaryNumber {
    public static void main(String[] args) {
        BinaryNumber binaryNumber = new BinaryNumber();
        binaryNumber.DFS(11);
    }

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            int m = n / 2;
            int s = n % 2;
            DFS(m);
            System.out.print(s);
        }
    }
}
