package slidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcdbea";
        System.out.println("ANSWER = " + findLongestSubstring(str));
    }

    public static int findLongestSubstring(String str) {
        char[] charray = str.toCharArray();
        int[] charcount = new int[127];
        int left = 0, right = 0, maxlen = 0;
        ;

        // Start iteration
        while (right < charray.length) {
            // NEw character comes in
            // increase it's count
            charcount[charray[right]]++;
            // System.out.println("NEW CHAR - " + charray[right]);

            // if it's count greater than current then move left to first appearance of that
            // character in current window
            if (charcount[charray[right]] > 1) {
                // Before moving record current window's lenght
                maxlen = (right - left) > maxlen ? right - left : maxlen;
                // System.out.println("LEFT =" + left + ", RIGHT=" + right + " , maxlen=" +
                // maxlen);
                while (charray[left] != charray[right]) {
                    charcount[charray[left]]--;
                    left++;
                    // System.out.println("LEFT =" + left + ", RIGHT=" + right + " , maxlen=" +
                    // maxlen);
                }
                // move once more to left
                left++;
                // System.out.println("LEFT =" + left + ", RIGHT=" + right + " , maxlen=" +
                // maxlen);
                // decrease count
                charcount[charray[right]]--;
            }
            right++;
        }
        // System.out.println("LEFT =" + left + ", RIGHT=" + right + " , maxlen=" +
        // maxlen);
        maxlen = (right - left) > maxlen ? right - left : maxlen;
        return maxlen;
    }
}
