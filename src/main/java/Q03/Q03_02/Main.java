package Q03.Q03_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] aList = new int[count];
        for (int i = 0; i < count; i++) {
            aList[i] = in.nextInt();
        }
        int bCount = in.nextInt();
        int[] bList = new int[bCount];
        for (int i = 0; i < bCount; i++) {
            bList[i] = in.nextInt();
        }
        for (int i : main.solution(aList, bList)) {
            System.out.print(i + " ");
        }
    }

    private List<Integer> solution(int[] a, int[] b) {
        List<Integer> num = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                num.add(a[p1++]);
                p2++;
            } else if (a[p1] < b[p2]) {
                p1++;
            } else
                p2++;
        }

        return num;
    }
    // my answer -> fail step 4
    /*public List<Integer> solution(int[] a, int[] b) {
        quickSort(a, 0, a.length - 1);
        quickSort(b, 0, b.length - 1);
        List<Integer> rs = new ArrayList<>();

        int[] minArr;
        int[] arr;
        if (a.length > b.length) {
            arr = a;
            minArr = b;
        } else {
            arr = b;
            minArr = a;
        }
        List<Integer> min = Arrays.stream(minArr).boxed().collect(Collectors.toList());
        int lastValue = min.get(min.size() - 1);
        for (int i : arr) {
            if (lastValue < i) {
                break;
            }
            if (min.contains(i)) {
                rs.add(i);
            }
        }
        return rs;
    }
    public void quickSort(int[] list, int leftPos, int rightPos) {
        if (leftPos >= rightPos) {
            return;
        }
        int q = partition(list, leftPos, rightPos);
        this.quickSort(list, leftPos, q - 1);
        this.quickSort(list, q + 1, rightPos);
    }

    private int partition(int[] list, int leftPos, int rightPos) {
        int low = leftPos;
        int high = rightPos;
        int pivot = list[leftPos];
        while (low < high) {

            while (high > low && list[high] > pivot) {
                high--;
            }
            while (low < high && list[low] <= pivot) {
                low++;
            }
            swap(list, low, high);
        }

        swap(list, leftPos, low);

        return low;
    }

    private void swap(int[] list, int low, int high) {
        int temp = list[low];
        list[low] = list[high];
        list[high] = temp;
    }

     */
}
