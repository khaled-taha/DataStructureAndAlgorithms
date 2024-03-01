package problemSolving.array_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa","aa"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String base = strs[0];

        int[] chars = new int[26];
        StringBuilder prefix = new StringBuilder();
        for (String str:strs) {
            for (int i = 0; i < str.length(); i++) chars[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < base.length(); i++) {
            if(chars[base.charAt(i) - 'a'] % strs.length == 0) {
                prefix.append(base.charAt(i));
            }else break;
        }
        return prefix.toString();
    }

}
