package part1.chapter4;

/**
 * @author Miles
 * @create 2021-12-15 10:21 AM
 * @email miles.j.hoo@gmail.com
 **/
public class MaximumSubarray {

    public int[] divideAndConquer(int[] arr) {
        return divideAndConquer(arr, 0, arr.length - 1);
    }

    private int[] divideAndConquer(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{left, right, arr[left]};
        }
        int mid = left + ((right - left) >> 1);
        int[] leftPart = divideAndConquer(arr, left, mid);
        int[] rightPart = divideAndConquer(arr, mid + 1, right);
        int[] midPart = maxIncludingMid(arr, left, mid, right);
        if (leftPart[2] >= rightPart[2] && leftPart[2] >= midPart[2]) {
            return leftPart;
        } else if (rightPart[2] >= leftPart[2] && rightPart[2] >= midPart[2]) {
            return rightPart;
        }
        return midPart;
    }

    private int[] maxIncludingMid(int[] arr, int left, int mid, int right) {
        int leftMost = -1, leftSum = Integer.MIN_VALUE, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftMost = i;
            }
        }
        sum = 0;
        int rightMost = -1, rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightMost = i;
            }
        }
        return new int[]{leftMost, rightMost, leftSum + rightSum};
    }

    public int[] dynamicProgramming(int[] arr) {
        int left = -1, right = -1, pre = Integer.MIN_VALUE, max = pre, n = arr.length;
        for (int i = 0; i < n; i++) {
            if (pre <= 0) {
                left = i;
            }
            pre = Math.max(arr[i], pre + arr[i]);
            if (pre > max) {
                right = i;
                max = pre;
            }
        }
        return new int[]{left, right, max};
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = maximumSubarray.divideAndConquer(arr);
        System.out.println(result[0] + ", " + result[1] + ", " + result[2]);
        result = maximumSubarray.dynamicProgramming(arr);
        System.out.println(result[0] + ", " + result[1] + ", " + result[2]);

    }
}
