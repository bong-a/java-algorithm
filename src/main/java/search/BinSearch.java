package search;

public class BinSearch {

    public static void main(String[] args) {
        BinSearch binSearch = new BinSearch();
        int[] arr = {1,4,6,7,9,10,15};
        int rs = binSearch.search(arr, 10);
        System.out.println(rs);
    }

    public int search(int[] arr, int target) {
        int pl = 0, pr = arr.length - 1;
        do {
            int pc = (pl + pr) / 2;
            if (arr[pc] == target) {
                return pc;
            } else if (arr[pc] < target) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        return -1;
    }
}
