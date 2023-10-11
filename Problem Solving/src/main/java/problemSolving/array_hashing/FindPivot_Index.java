package problemSolving.array_hashing;

public class FindPivot_Index {

    public int pivotIndex(int[] nums) {
        int left, right, total = 0;
        for (int num : nums) total += num;

        for (int i = 0; i < nums.length; i++) {
            left = (i == 0) ? 0 : nums[i - 1];
            right = (i == nums.length - 1) ? 0 : total - (left + nums[i]);

            if(left == right) return i;
            else nums[i] += left;
        }
        return -1;
    }
}
