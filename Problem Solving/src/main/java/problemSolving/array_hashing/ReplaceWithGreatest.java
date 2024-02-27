package problemSolving.array_hashing;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * Example 2:
 *
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 105
 */
public class ReplaceWithGreatest {
    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr); // O(n)
        System.out.println(Arrays.toString(arr));
    }

    public static int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        int temp;
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            temp = Math.max(max, arr[i]);
            arr[i] = max;
            max = temp;
        }
        return arr;
    }

    public int[] replaceElements_V2(int[] arr) {
        int max, temp;
        max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0 ; i--) {
            temp = arr[i];
            arr[i] = max;
            if(temp > max) max = temp;
        }
        return arr;
    }
}
