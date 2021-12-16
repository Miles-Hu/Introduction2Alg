package part2.chapter6;


import utils.Utils;

/**
 * @author Miles
 * @create 2021-12-15 10:21 AM
 * @email miles.j.hoo@gmail.com
 **/
public class HeapSort {

    private int leftChildren(int root) {
        return (root << 1) + 1;
    }

    private int rightChildren(int root) {
        return (root << 1) + 2;
    }



    private void maxHeapify(int[] arr, int root, int heapSize) {
        int l = leftChildren(root), r = rightChildren(root);
        int largest = root, length = heapSize - 1;
        if (l <= length && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r <= length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != root) {
            Utils.swap(arr, root, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int index = arr.length - 1;
        for (int i = (index >> 1); i >= 0; i--) {
            maxHeapify(arr, i, arr.length - 1);
        }
    }

    private void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            Utils.swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 5, 1, 8, 2, 7, 6, 0};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
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
