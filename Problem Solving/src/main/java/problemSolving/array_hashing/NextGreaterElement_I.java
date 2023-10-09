package problemSolving.array_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class NextGreaterElement_I {

    /**
     * 41.88MB :  Beats 97.79%of users with Java
     * O(n^2) = 5ms
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int foundedIndex;
        for (int i = 0; i < nums1.length; i++) {
            foundedIndex = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) foundedIndex = j;
                else if(foundedIndex != -1 && nums2[j] > nums2[foundedIndex]){
                    nums1[i] = nums2[j];
                    foundedIndex = -1;
                    break;
                }
            }
            if(foundedIndex != -1) nums1[i] = -1;
        }
        return nums1;
    }


    /**
     * 2ms : Beats 99.32%of users with Java
     * 42.75MB : Beats 83.94%of users with Java
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums2MapIndex= new HashMap<>();
        for(int i = 0; i < nums2.length; i++) nums2MapIndex.put(nums2[i],i);

        for(int j = 0; j < nums1.length; j++){
            int nums1Index = nums2MapIndex.get(nums1[j]);
            nums1[j] = -1;

            for(int nums2Index = nums1Index + 1; nums2Index < nums2.length; nums2Index++){
                if(nums2[nums1Index] < nums2[nums2Index]){
                    nums1[j] = nums2[nums2Index];
                    break;
                }
            }
        }
        return nums1;
    }


}
