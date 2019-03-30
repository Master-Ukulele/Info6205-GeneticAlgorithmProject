public class BinarySearch {

    static int binarySearch(Comparable[] a, int lo, int hi, Comparable x) {
        if (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (a[mid] == x) {
                return mid;
            }
            if (a[mid].compareTo(x) < 0) {
                return binarySearch(a, mid + 1, hi, x);
            }
            if (a[mid].compareTo(x) > 0) {
                return binarySearch(a, lo, mid - 1, x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 7, 9, 2, 6, 4, 8, 10};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 11));
    }

}
