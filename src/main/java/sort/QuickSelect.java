package sort;

public class QuickSelect {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return a[k];
            }
        }
        return a[k];
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (a[++i].compareTo(a[lo]) < 0) {
                if (i == hi) {
                    break;
                }
            }
            while (a[lo].compareTo(a[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            Comparable tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Comparable tmp2 = a[lo];
        a[lo] = a[j];
        a[j] = tmp2;
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 5, 9, 7, 2, 6, 4, 8, 10};
        System.out.print("Input array: ");
        for (int oo : arr)
            System.out.print(oo + " ");
        int r = 1;
        System.out.print("\nRank " + r + ": " + select(arr, r - 1));
    }
}
