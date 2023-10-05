package problemSolving.array_hashing;

import java.util.Arrays;
import java.util.HashSet;

public class IsomorphicStrings {

    public boolean isIsomorphic1(String s, String t) { // 35 / 44 testcases passed
        HashSet<Character> firstString = new HashSet<>();
        HashSet<Character> secondString = new HashSet<>();
        for (Character ch : s.toCharArray()) firstString.add(ch);
        for (Character ch : t.toCharArray()) secondString.add(ch);
        return firstString.size() == secondString.size();
    }

        public boolean isIsomorphic(String s, String t) { // ASCII Code : 4ms
            if (s.length() != t.length()) {
                return false;
            }

            int[] sToTMapping = new int[256];
            int[] tToSMapping = new int[256];

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);

                if (sToTMapping[charS] != 0) {
                    if (sToTMapping[charS] != charT) {
                        return false; // s maps to different characters in t
                    }
                } else {
                    if (tToSMapping[charT] != 0) {
                        return false; // charT is already mapped to a different character in s
                    }
                    sToTMapping[charS] = charT;
                    tToSMapping[charT] = charS;
                }
            }

            return true;
        }
}
