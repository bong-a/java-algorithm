package sort;

public class ShellInsertSort {
    public static void main(String[] args) {
        ShellInsertSort main = new ShellInsertSort();
        // int[] arr = {6, 4, 3, 7, 1, 9, 8};
        // int[] arr = {8, 1, 4, 2, 7, 6, 3, 5};
        int[] arr = {22, 5, 11, 32, 120, 68, 70, 20, 12, 15, 43, 34, 33, 30, 2, 1, 13, 23, 29, 9, 64, 50, 55};
        main.sort(arr);
        //print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void sort(int[] arr) {
        shellSort(arr, arr.length);
    }

    public void shellSort(int[] num, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            System.out.println("====== h = " + h + " ======");
            for (int i = h; i < n; i++) {
                int j;
                int tmp = num[i];
                for (j = i - h; j >= 0 && num[j] > tmp; j -= h) {
                    // System.out.println("num[" + (j + h) + "]=" + num[j + h] +
                    //     "=> num[" + j + "]=" + num[j] + ", tmp=" + tmp);
                    num[j + h] = num[j];
                }
                num[j + h] = tmp;
                // System.out.print("j=" + j + ",h=" + h + "->");
                // System.out.println("num[" + (j + h) + "]=" + num[j + h]);

            }
            print(num);

        }
    }

    public void shellSort2(int[] num, int n) {
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1) {

        }
        for (; h > 0; h /= 3) {
            System.out.println("h=" + h);
            for (int i = h; i < n; i++) {
                int j;
                int tmp = num[i];
                for (j = i - h; j >= 0 && num[j] > tmp; j -= h) {
                    num[j + h] = num[j];
                }
                num[j + h] = tmp;
            }
            print(num);

        }
    }

}
