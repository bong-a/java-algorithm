package algorithm.sort;

public class InsertSort {
    public static void main(String[] args) {
        InsertSort main = new InsertSort();
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        main.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void sort(int[] arr) {
        insertSort(arr);
    }

    public int[] insertSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int j;
            int tmp = num[i];
            for (j = i; j > 0 && num[j - 1] > tmp; j--) {
                num[j] = num[j - 1];
            }
            num[j] = tmp;
        }
        return num;
    }
}
