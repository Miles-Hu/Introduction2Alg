package part2.chapter6;

/**
 * @author Miles
 * @create 2021-12-15 11:42 AM
 * @email miles.j.hoo@gmail.com
 **/

public class PriorityQueue {

    private int[] arr;
    private int size;

    public PriorityQueue() {
        this.arr = new int[16];
        size = 0;
    }

    public void insert(int num) {
        if (size == arr.length) {
            grow();
        }
        arr[size++] = num;
        siftUp(size - 1);
    }

    public int maximum() {
        checkEmpty();
        return arr[0];
    }

    public int extractMax() {
        checkEmpty();
        int num = arr[0];
        arr[0] = arr[--size];
        siftDown(0);
        return num;
    }

    public void increaseKey(int index, int key) {
        if (arr[index] > key) {
            throw new IllegalArgumentException("key is too small!");
        }
        arr[index] = key;
        siftUp(index);
    }

    private void siftUp(int index) {
        int parent = parent(index);
        while (parent >= 0 && arr[index] > arr[parent]) {
            swap(index, parent);
            index = parent;
            parent = parent(index);
        }
    }

    private void siftDown(int root) {
        int l = leftChild(root), r = rightChild(root);
        while (l <= size) {
            int max = arr[l], mIndex = l;
            if (r <= size && arr[r] > max) {
                max = arr[r];
                mIndex = r;
            }
            if (arr[root] >= max) {
                break;
            }
            swap(root, mIndex);
            root = mIndex;
            l = leftChild(root);
            r = rightChild(root);
        }
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void grow() {
        int newLen = (arr.length << 1);
        int[] newArr = new int[newLen];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    private int parent(int index) {
        return (index - 1) >> 1;
    }

    private int leftChild(int root) {
        return (root << 1) + 1;
    }

    private int rightChild(int root) {
        return (root << 1) + 2;
    }

    private void checkEmpty() {
        if (size == 0) {
            throw new RuntimeException("the PriorityQueue is empty!");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 5, 1, 8, 2, 7, 6, 0};
        PriorityQueue pq = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
            pq.insert(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.extractMax());
            if (!pq.isEmpty()) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }
}
