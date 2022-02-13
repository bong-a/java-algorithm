package sort;

public class BinaryInsertSort {
    public static void main(String[] args) {
        BinaryInsertSort main = new BinaryInsertSort();
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
            int tmp = num[i];
            int location = binarySearch(num, tmp, 0, i);
            int j = i - 1;
            while (j >= location) {
                num[j + 1] = num[j];
                j--;
            }
            num[location] = tmp;
        }
        return num;
    }

    static int binarySearch(int[] a, int key, int lo, int hi) {

        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;    // 중간 위치

            if (key < a[mid]) {    // key < a[mid]라면 탐색 상한선을 중간위치로 변경
                hi = mid;
            } else {                // 그 외엔 하한선을 중간 다음 위치로 변경
                lo = mid + 1;
            }
        }
        return lo;
    }
}
