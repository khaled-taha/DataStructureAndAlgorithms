package problemSolving.array_hashing;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement1(int[] nums) { // O(n log(n) + n) = 5ms
        Arrays.sort(nums);
        int temp = nums[0];
        int tempMax = 0, finalMax = 0, majorityElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == temp) tempMax++;
            if(nums[i] != temp || i == nums.length - 1){
                if(finalMax <= tempMax) {
                    finalMax = tempMax;
                    majorityElement = temp;
                }
                temp = nums[i];
                tempMax = 0;
            }
        }
        return majorityElement;
    }

    public int majorityElement2(int[] nums) { // O(n log(n)) = 2ms
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) { // O(n) = 1ms
        int max = 0;
        int element = 0;

        for (int num : nums) {
            if (max == 0) {
                element = num;
            }

            if (num == element) {
                max++;
            } else {
                max--;
            }
        }

        return element;
    }


}
