package problemSolving.array_hashing;

public class MaximumNumberOfBalloons {


    /**
     * Runtime 1 ms Beats 100%
     * Memory 40.9 MB Beats 71.77%
     */
    public int maxNumberOfBalloons1(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (char aChar : text.toCharArray())
            switch (aChar) {
                case 'b' -> b++;
                case 'a' -> a++;
                case 'l' -> l++;
                case 'o' -> o++;
                case 'n' -> n++;
            }
        return Math.min(Math.min(Math.min(b,a),n), Math.min(l/2,o/2));
    }

    public int maxNumberOfBalloons2(String text) { // 3ms
        int[] arr = new int[26];

        for (int i = 0; i < text.length(); i++) {
            arr[text.charAt(i) - 'a']++;
        }

        return Math.min(Math.min(Math.min(arr[0], arr[1]), arr[13]), Math.min(arr[11] / 2, arr[14] / 2));
    }


}
