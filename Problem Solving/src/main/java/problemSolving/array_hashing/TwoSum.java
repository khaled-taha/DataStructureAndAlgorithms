package problemSolving.array_hashing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution1(nums, 9)));
    }
    public static int[] solution1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);
            if(val != null) return new int[]{i, val};
            else map.put(nums[i], i);
        }
        return null;
    }
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> numIndexMapping = new HashMap<>();
        int secondIndex;
        for(int i = 0; i < nums.length; i++) {
            secondIndex = numIndexMapping.getOrDefault(target - nums[i], -1);
            if(secondIndex != -1){
                return new int[]{i, secondIndex};
            }
            numIndexMapping.put(nums[i], i);
        }
        return null;
    }
}

