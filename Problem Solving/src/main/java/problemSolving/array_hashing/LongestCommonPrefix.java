package problemSolving.array_hashing;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"dog","racecar","car"}));
    }

    public static String solution(String[] strs){
        StringBuilder builder = new StringBuilder();
        boolean isCommon = true;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)){
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) builder.append(strs[0].charAt(i));
            else break;
        }
        return builder.toString();
    }

    public static String solution2(String[] strs) {
        if(strs.length == 1) return strs[0];
        int minLength = 200;
        StringBuilder prefix = new StringBuilder();
        for(String str : strs) minLength = Math.min(str.length(), minLength);

        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != ch) return prefix.toString();
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

}
