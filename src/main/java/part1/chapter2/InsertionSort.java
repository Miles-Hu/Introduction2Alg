package part1.chapter2;

/**
 * @author Miles
 * @create 2021-12-15 10:21 AM
 * @email miles.j.hoo@gmail.com
 **/
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j], i = j - 1;
            //Insert A[j] into the sorted sequence A[0..j - 1].
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 5, 1, 8, 2, 7, 6, 0};
        insertionSort(arr);
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (i != n - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
