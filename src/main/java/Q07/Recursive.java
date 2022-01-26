package Q07;

public class Recursive {
    public static void main(String[] args) {
        Recursive recursive = new Recursive();
        recursive.DFS(3);
    }

    public void DFS(int n) {
        if (n == 0)
            return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }
}
