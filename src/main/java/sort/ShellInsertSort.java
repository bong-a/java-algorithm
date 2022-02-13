package sort;

public class ShellInsertSort {
    public static void main(String[] args) {
        ShellInsertSort main = new ShellInsertSort();
        // int[] arr = {6, 4, 3, 7, 1, 9, 8};
        int[] arr = {8, 1, 4, 2, 7, 6, 3, 5};
        main.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void sort(int[] arr) {
        shellSort2(arr, arr.length);
    }

    public void shellSort(int[] num, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = num[i];
                for (j = i - h; j >= 0 && num[j] > tmp; j -= h) {
                    num[j + h] = num[j];
                }
                num[j + h] = tmp;

            }

        }
    }

    public void shellSort2(int[] num, int n) {
        int h;
        for (h = 1; h < n; h = h * 3 + 1) {

        }
        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = num[i];
                for (j = i - h; j >= 0 && num[j] > tmp; j -= h) {
                    num[j + h] = num[j];
                }
                num[j + h] = tmp;

            }

        }
    }

}
