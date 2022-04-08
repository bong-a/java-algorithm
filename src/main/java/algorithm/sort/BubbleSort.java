package algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort main = new BubbleSort();
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        main.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void sort(int[] arr) {
        int k = 0;
        while (k < arr.length - 1) {
            int last = arr.length - 1;
            for (int i = arr.length - 1; i > k; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, i - 1);
                    last = i;
                }
            }
            k = last;
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
