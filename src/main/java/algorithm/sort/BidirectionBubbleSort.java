package algorithm.sort;

public class BidirectionBubbleSort {
    // = 칵테일 정렬(cocktail sort)
    // = 셰이커 정렬(shaker sort)
    public static void main(String[] args) {
        BidirectionBubbleSort main = new BidirectionBubbleSort();
        // int[] arr = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {6, 4, 3, 7, 1, 9, 8};
        main.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void sort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sLast = arr.length - 1;
            int eLast = 0;
            for (int j = end; j > start; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                    sLast = j;
                }
            }
            start = sLast;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    eLast = i;
                }
            }
            end = eLast;
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
