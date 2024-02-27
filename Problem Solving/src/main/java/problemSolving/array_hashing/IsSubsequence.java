package problemSolving.array_hashing;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some
 * (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence1("axc", "ahbgdc"));
    }

    public static boolean isSubsequence1(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int indexS = 0;

        if(sLength > tLength) return false;
        if(sLength == 0) return true;
        for (int i = 0; i < tLength && indexS != sLength; i++) {
            if(t.charAt(i) == s.charAt(indexS)) indexS++;
        }
        return indexS == sLength;
    }

    public static boolean isSubsequence2(String s, String t) {
        int sIndex = 0;
        for (char c : t.toCharArray()) {
            if (sIndex < s.length() && c == s.charAt(sIndex)) sIndex++;
        }
        return sIndex == s.length();
    }

    public boolean isSubsequence3(String s, String t) {
        if(s.length() == 0) return false;
        int pointerS = 0;
        for(char ch : t.toCharArray()){
            if(ch == s.charAt(pointerS)) pointerS++;
            if(pointerS == s.length()) return true;
        }
        return false;
    }
}
