package programmers;

import java.util.Scanner;
import java.util.Stack;

public class Q_43164 {
    public static void main(String[] args) {
        Q_43164 q = new Q_43164();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] tickets = new String[n][2];
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 2; j++) {
                tickets[i][j] = in.next();
            }
        }
        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(tickets[i][j] + " ");
            }
            System.out.println("");
        }
        String[] answer = q.solution(tickets);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }

    public String[] solution(String[][] tickets) {
        String[] ans = null;
        quickSort(tickets, 0, tickets.length - 1);
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                String[] answer = new String[tickets.length + 1];
                moveToFirst(tickets, i);
                int[] visit = new int[tickets.length];
                int n = tickets.length;
                answer[0] = tickets[0][0];
                answer[1] = tickets[0][1];
                visit[0] = 1;
                // System.out.println(tickets[0][0] + "->" + tickets[0][1]);
                ans = dfs(n, 1, tickets, visit, answer);
                if (ans != null) {
                    break;
                }
                rollBack(tickets, i);
            }
        }

        return ans;
    }

    private void rollBack(String[][] tickets, int i) {
        int k;
        String[] tmp = tickets[0];
        for (k = 0; k < i; k++) {
            tickets[k] = tickets[k + 1];
        }
        tickets[k] = tmp;
    }

    private void moveToFirst(String[][] tickets, int i) {
        int k;
        String[] tmp = tickets[i];
        for (k = i; k > 0; k--) {
            tickets[k] = tickets[k - 1];
        }
        tickets[k] = tmp;
    }

    private String[] dfs(int n, int m, String[][] tickets, int[] visit, String[] answer) {
        if (m == n) {
            for (int j : visit) {
                if (j == 0) {
                    return null;
                }
            }
            return answer;
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (visit[i] == 0 && answer[m].equals(tickets[i][0])) {
                    //System.out.println(m + "::" + tickets[i][0] + "->" + tickets[i][1]);
                    visit[i] = 1;
                    answer[m + 1] = tickets[i][1];
                    String[] a = dfs(n, m + 1, tickets, visit, answer);
                    if (a != null) {
                        return a;
                    }
                    answer[m + 1] = null;
                    visit[i] = 0;
                }
            }
        }
        return null;
    }

    public void quickSort(String[][] arr, int s, int e) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(s);
        rstack.push(e);

        while (!lstack.isEmpty()) {
            int pl = s = lstack.pop();
            int pr = e = rstack.pop();
            int pivot = (pl + pr) / 2;
            String x = arr[pivot][1];
            do {
                //find arr[pl]>x index
                while (arr[pl][1].compareTo(x) < 0) {
                    pl++;
                }
                //find pr<x index
                while (arr[pr][1].compareTo(x) > 0) {
                    pr--;
                }
                if (pl <= pr) {
                    swap(arr, pl++, pr--);
                }
            } while (pl <= pr);

            int x1 = pr - s;
            int x2 = e - pl;

            if (x1 >= x2) {
                if (s < pr) {
                    lstack.push(s);
                    rstack.push(pr);
                }
                if (pl < e) {
                    lstack.push(pl);
                    rstack.push(e);
                }
            } else {
                if (pl < e) {
                    lstack.push(pl);
                    rstack.push(e);
                }
                if (s < pr) {
                    lstack.push(s);
                    rstack.push(pr);
                }
            }
        }
    }

    private void swap(String[][] arr, int idx1, int idx2) {
        String[] temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
