package utils;

/**
 * @author Miles
 * @create 2021-12-15 4:50 PM
 * @email miles.j.hoo@gmail.com
 **/

public class Utils {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
