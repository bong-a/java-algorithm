package sort;

public class MergeSort {
    static int[] buff;

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        // int[] arr = {1, 12, 8, 7, 11, 4, 5, 10, 2, 6, 3, 9};
        int[] arr = {22,5,11,32,120,68,70};
        buff = new int[arr.length];
        sort.mergeSort(arr, 0, arr.length - 1);
        buff = null;
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public void mergeSort(int[] arr, int left, int right) {
        System.out.println("left:"+left+",right:"+right);
        if (left < right) {
            System.out.println("cal");
            int i;//b 배열 역할 인덱스
            int center = (left + right) / 2;
            int p = 0; //왼쪽 정렬 복사한 배열 인덱스, 아래 for문 돌고나면 center
            int j = 0; //a 배열(왼쪽 정렬 배열) 인덱스
            int k = left;// c 배열 역할

            mergeSort(arr, left, center);
            mergeSort(arr, center+1, right);

            //buff에 왼쪽 정렬된거 복사
            for (i = left; i <= center; i++) {
                buff[p++] = arr[i];
            }
            // i=center+1이므로 center+1 ~ right까지 연산,b배열 역할
            while (i <= right && j < p) {
                arr[k++] = (buff[j] <= arr[i]) ? buff[j++] : arr[i++];
            }
            while (j < p) {
                System.out.println("a 배열 나머지 복사");
                arr[k++] = buff[j++];
            }

            print(arr);
        }
    }

    private void merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ax = 0, bx = 0;
        int cx = 0;
        while (ax < a.length && bx < b.length) {
            if (a[ax] >= b[bx]) {
                c[cx++] = a[ax++];
            } else {
                c[cx++] = b[bx++];
            }
        }

        while (ax < a.length) {
            c[cx++] = a[ax++];
        }
        while (bx < b.length) {
            c[cx++] = b[bx++];
        }
    }
}
