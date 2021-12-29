package Q03;

public class QuickSort {
    public void quickSort(int[] list, int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int q = partition(list, leftPos, rightPos);
            this.quickSort(list, leftPos, q - 1);
            this.quickSort(list, q + 1, rightPos);
        }
    }

    private int partition(int[] list, int leftPos, int rightPos) {
        int low = leftPos;
        int high = rightPos + 1;
        int pivot = list[leftPos];
        do {
            do {
                low++;
            } while (low <= rightPos && list[low] < pivot);

            do {
                high--;
            } while (high >= leftPos && list[high] > pivot);

            if (low < high) {
                swap(list, low, high);
            }
        } while (low < high);

        swap(list, low, high);

        return high;
    }

    private void swap(int[] list, int low, int high) {
        int temp = list[low];
        list[low] = high;
        list[high] = temp;
    }

}
