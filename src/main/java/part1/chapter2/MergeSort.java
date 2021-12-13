package part1.chapter2;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1); // divide
        sort(arr, l, mid); // conquer
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r); // combine
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int len = r - l + 1;
        int[] auxArr = new int[len];
        int index = 0, i = l, j = mid + 1;
        while (i <= mid || j <= r) {
            if (i > mid) {
                auxArr[index++] = arr[j++];
            } else if (j > r) {
                auxArr[index++] = arr[i++];
            } else if (arr[i] <= arr[j]) {
                auxArr[index++] = arr[i++];
            } else {
                auxArr[index++] = arr[j++];
            }
        }
        for (i = 0; i < len; i++) {
            arr[i + l] = auxArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 5, 1, 8, 2, 7, 6, 0};
        mergeSort(arr);
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
