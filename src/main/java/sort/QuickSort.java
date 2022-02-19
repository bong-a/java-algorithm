package sort;

import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        // int[] arr = {1, 8, 7, 4, 5, 2, 6, 3, 9};
        int[] arr = {1, 12,8, 7, 11,4, 5, 10,2, 6, 3, 9};
        sort.quickSort3(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void quickSort(int[] arr, int s, int e) {
        int pl = s;
        int pr = e;
        int pivot = (pl + pr) / 2;
        int x = arr[pivot];

        do {
            //find arr[pl]>x index
            while (arr[pl] < x) {
                pl++;
            }
            //find pr<x index
            while (arr[pr] > x) {
                pr--;
            }
            // System.out.println("pl:" + pl + ",pr:" + pr);
            if (pl <= pr) {
                // System.out.println("swap");
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        //printInfo(arr, s, e, pl, pr, x);
        print(arr, s, e);
        //왼쪽
        if (s < pr) {
            quickSort(arr, s, pr);
        }
        if (pl < e) {
            quickSort(arr, pl, e);
        }
    }

    private void print(int[] arr, int s, int e) {
        System.out.printf("a[%d]~a[%d] : {", s, e);
        for (int i = s; i < e; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[e] + "}");
    }

    private void printInfo(int[] arr, int s, int e, int pl, int pr, int x) {
        System.out.println("피벗 값 :" + x);
        System.out.println("피벗 이하 그룹");
        for (int i = s; i < pl; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        if (pl > pr + 1) {
            System.out.println("피벗 값과 일치하는 그룹");
            for (int i = pr + 1; i < pl; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i <= e; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public void quickSort2(int[] arr, int s, int e) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(s);
        rstack.push(e);

        while (!lstack.isEmpty()) {
            int pl = s = lstack.pop();
            int pr = e = rstack.pop();
            int pivot = (pl + pr) / 2;
            int x = arr[pivot];
            do {
                //find arr[pl]>x index
                while (arr[pl] < x) {
                    pl++;
                }
                //find pr<x index
                while (arr[pr] > x) {
                    pr--;
                }
                // System.out.println("pl:" + pl + ",pr:" + pr);
                if (pl <= pr) {
                    // System.out.println("swap");
                    swap(arr, pl++, pr--);
                }
            } while (pl <= pr);

            print(arr, s, e);
            if (s < pr) {
                lstack.push(s);
                rstack.push(pr);
            }
            if (pl < e) {
                lstack.push(pl);
                rstack.push(e);
            }
        }
    }

    //분할범위가 많은것부터 PUSH
    public void quickSort3(int[] arr, int s, int e) {
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();

        lstack.push(s);
        rstack.push(e);

        while (!lstack.isEmpty()) {
            int pl = s = lstack.pop();
            int pr = e = rstack.pop();
            int pivot = (pl + pr) / 2;
            int x = arr[pivot];
            do {
                //find arr[pl]>x index
                while (arr[pl] < x) {
                    pl++;
                }
                //find pr<x index
                while (arr[pr] > x) {
                    pr--;
                }
                // System.out.println("pl:" + pl + ",pr:" + pr);
                if (pl <= pr) {
                    // System.out.println("swap");
                    swap(arr, pl++, pr--);
                }
            } while (pl <= pr);

            print(arr, s, e);

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
}
