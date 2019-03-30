package sort;

public class ShellSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                    Comparable temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 5, 9, 7, 2, 6, 4, 8, 10};
        System.out.print("Input array: ");
        for (int oo : arr)
            System.out.print(oo + " ");
        sort(arr);
        System.out.print("\nSorted array: ");
        for (int a : arr) System.out.print(a + " ");
    }

}
