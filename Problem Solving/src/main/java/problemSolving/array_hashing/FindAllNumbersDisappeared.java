package problemSolving.array_hashing;

import java.util.*;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 */
public class FindAllNumbersDisappeared {

    public List<Integer> findDisappearedNumbers1(int[] nums) { // n log(n)
        List<Integer> integers = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(Arrays.binarySearch(nums, i + 1) < 0) integers.add(i + 1);
        }
        return integers;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) { // O(n) ==> 3ms Beats 99.38%
        int[] numbers = new int[nums.length];
        ArrayList <Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numbers[nums[i] - 1] = nums[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) list.add(i + 1);
        }

        return list;
    }



}
