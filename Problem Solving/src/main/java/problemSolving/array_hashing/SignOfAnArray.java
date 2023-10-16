package problemSolving.array_hashing;

public class SignOfAnArray {
    public int arraySign(int[] nums) {
        int positive = 0, negative = 0, zero = 0;
        for (int num:nums) {
            if(num == 0) zero++;
            else if (num > 0) positive++;
            else negative++;
        }
        if(zero > 0) return 0;
        if(negative % 2 == 0) return 1;
        return -1;
    }
}
