package problemSolving.array_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(solution1("anagram", "nagaram"));
        System.out.println(solution2("rat", "car"));
    }

    public static boolean solution1(String s, String t){ // n^2 => worst & Space Complexity O(n)
        if (s.length() != t.length()) return false;
        List<Character> characters = new ArrayList<>();
        int len1 = s.length();
        int len2 = t.length();

        for (int i = 0; i < len1; i++) characters.add(s.charAt(i)); // n
        for (int i = 0; i < len2; i++){ // n
            int index = characters.indexOf(t.charAt(i));
            if(index != -1) characters.set(index, ' ');
            else return false;
        }
        return true;
    }


    public static boolean solution2(String s, String t) { // n => Fair & Space Complexity O(1)
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];

        for(char c : s.toCharArray()) charCount[c - 'a']++;
        for(char c : t.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) return false;
        }
        return true;
    }

}
