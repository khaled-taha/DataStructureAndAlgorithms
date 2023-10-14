package problemSolving.array_hashing;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToStr = new HashMap<>();
        Map<String, Character> strToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String word = words[i];

            if (patternToStr.containsKey(p)) {
                if (!patternToStr.get(p).equals(word)) {
                    return false; // Mismatch in the mapping.
                }
            } else {
                patternToStr.put(p, word);
            }

            if (strToPattern.containsKey(word)) {
                if (strToPattern.get(word) != p) {
                    return false; // Mismatch in the mapping.
                }
            } else {
                strToPattern.put(word, p);
            }
        }

        return true;
    }

}
