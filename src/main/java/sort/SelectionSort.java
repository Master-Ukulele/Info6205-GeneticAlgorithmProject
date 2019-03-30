package sort;

public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    Comparable temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
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
