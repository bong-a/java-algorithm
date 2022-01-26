package Q07;

public class SubSetDFS {
    static int n;
    static int[] ch;

    public static void main(String[] args) {
        SubSetDFS subSetDFS = new SubSetDFS();
        n = 10;
        ch = new int[n + 1];
        subSetDFS.DFS(1);
    }

    public void DFS(int L) {
        if (L == n + 1) {
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

}

