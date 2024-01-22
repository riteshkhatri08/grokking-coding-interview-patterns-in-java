package slidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println("ANSWER = " + longestRepeatingCharacterReplacement(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int left = 0, right = 0, maxsofar = 0;
        // System.out.println("STRING = " + s);
        char[] charray = s.toCharArray();
        char maxchar = charray[left];
        HashMap<Character, Integer> charcount = new HashMap<Character, Integer>();
        // charcount.put(charray[left], 1);
        maxchar = charray[left];
        for (; right < charray.length; right++) {
            // System.out.println("NEW CHAR CAME IN - " + charray[right] + " , right=" +
            // right);
            charcount.put(charray[right], charcount.getOrDefault(charray[right], 0) + 1);
            // System.out.println("CHAR COUNT = " + charcount);

            // Check if current character same as max character
            if (maxchar != charray[right]) {

                // Check how many characters have we replaced already
                int replaced;
                if (charcount.get(maxchar) < charcount.get(charray[right])) {
                    maxchar = charray[right];
                    // System.out.println(" New max xhar " + maxchar);
                }
                replaced = right - left - charcount.get(maxchar) + 1;
                // System.out.println("Replaced = " + replaced);
                while (replaced > k) {

                    // time to shrink window
                    charcount.put(charray[left], charcount.get(charray[left]) - 1);
                    left++;
                    // System.out.println("decrease window, char count" + charcount + " , left=" +
                    // left);
                    if ((right - left + 1) > maxsofar) {
                        maxsofar = right - left + 1;
                    }
                    // Now get the new max char
                    for (char key : charcount.keySet()) {
                        if (charcount.get(maxchar) < charcount.get(key)) {
                            maxchar = key;
                        }
                        replaced = right - left - charcount.get(maxchar) + 1;
                    }

                }

            } else {
                if ((right - left) > maxsofar) {
                    maxsofar = right - left;
                }

            }

        }
        if (right == charray.length) {
            if (right - left > maxsofar) {
                maxsofar = right - left;
            }
        }
        return maxsofar;
    }
}