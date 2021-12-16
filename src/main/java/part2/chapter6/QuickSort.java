package part2.chapter6;


import utils.Utils;

import java.util.Random;

/**
 * @author Miles
 * @create 2021-12-15 4:42 PM
 * @email miles.j.hoo@gmail.com
 **/

public class QuickSort {

    Random random = new Random(System.currentTimeMillis());

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = randomPartition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private int randomPartition(int[] arr, int l, int r) {
        int p = l + random.nextInt(r - l);
        Utils.swap(arr, p, r);
        return partition(arr, l, r);
    }

    private int partition(int[] arr, int l, int r) {
        int num = r, i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < num) {
                Utils.swap(arr, ++i, j);
            }
        }
        Utils.swap(arr, ++i, r);
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 5, 1, 8, 2, 7, 6, 0};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
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
