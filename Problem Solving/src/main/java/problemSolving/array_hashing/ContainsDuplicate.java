package problemSolving.array_hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(solution_1(arr));
    }

    public static boolean solution_1(int[] arr){ // O(n)
        // with hashset
        Set<Integer> set = new HashSet<>();
        for (int item: arr) set.add(item); /* add => O(1) */
        return arr.length != set.size();
    }
}
