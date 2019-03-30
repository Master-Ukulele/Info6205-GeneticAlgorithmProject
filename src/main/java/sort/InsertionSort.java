package sort;

public class InsertionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    Comparable temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 5, 9, 7, 2, 6, 4, 8, 10};
        System.out.print("Input array: ");
        for (int oo : arr)
            System.out.print(oo + " ");
        sort(arr);
        System.out.print("\nSorted array: ");
        for (int a : arr)
            System.out.print(a + " ");
    }
}
