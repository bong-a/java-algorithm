package algorithm.sort;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] arr = {10, 9, 5, 8, 3, 2, 4, 6, 7, 1};
        sort.heapSort(arr);
        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            downHeap(arr, i, n - 1);
        }
        print(arr);
        System.out.println("sort start");
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
            print(arr);
        }
    }

    private void downHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        int child, parent;

        //가장 하단에 있는 부모 노드 : (end+1)/2
        for (parent = start; parent < (end + 1) / 2; parent = child) {
            // 왼쪽 자식 노드 : parent*2+1
            // 오른쪽 자식 노드 : parent*2+2
            int cl = parent * 2 + 1;
            int cr = cl + 1;

            child = (cr <= end && arr[cr] > arr[cl]) ? cr : cl;
            // System.out.println("parent=" + parent + ", temp=" + temp + " ,child=" + child);
            // System.out.println("cl=" + cl + ", cr=" + cr);
            if (temp >= arr[child]) {
                break;
            }
            arr[parent] = arr[child];
        }
        arr[parent] = temp;
        // System.out.println("parent=" + parent + ", arr[parent]=" + arr[parent]);
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
