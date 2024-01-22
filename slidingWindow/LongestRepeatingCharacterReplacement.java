// https://www.educative.io/courses/grokking-coding-interview-patterns-java/longest-repeating-character-replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/description/

package slidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "aaacbbbaabab";
        int k = 2;
        System.out.println("ANSWER = " + longestRepeatingCharacterReplacement(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        int[] charcount = new int[123];

        int left = 0, right = 0, maxsofar = 0;

        // System.out.println("STRING = " + s);
        char[] charray = s.toCharArray();
        char maxchar = charray[left];

        // charcount.put(charray[left], 1);
        maxchar = charray[left];
        for (; right < charray.length; right++) {

            System.out.println("NEW CHAR CAME IN - " + charray[right] + " , right=" +
                    right);

            // Increment count of current character
            charcount[charray[right]]++;

            System.out.println("CHAR COUNT = " + print(charcount));

            // Check if current character same as max character
            if (maxchar != charray[right]) {

                // Check if there's change in max char due to new character
                if (charcount[maxchar] < charcount[charray[right]]) {
                    maxchar = charray[right];
                    System.out.println(" New max xhar " + maxchar);
                } else {
                    // Check how many characters have we replaced already
                    System.out.println("Replaced = " + (right - left - charcount[maxchar] + 1));
                    while ((right - left - charcount[maxchar] + 1) > k) {

                        // time to shrink window
                        charcount[charray[left]]--;
                        left++;

                        System.out.println("decrease window, char count" + print(charcount) + " , left=" +
                                left);

                        // Now get the new max char
                        maxchar = getMostRecurringCharacter(charcount);

                    }
                }

            } else {
                // Then no issue, we as we are not increasing replace count
                if ((right - left + 1) > maxsofar) {
                    maxsofar = right - left + 1;
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

    public static char getMostRecurringCharacter(int[] charcount) {
        int maxindex = 97;
        for (int curindex = 97; curindex < charcount.length; curindex++) {
            if (charcount[maxindex] < charcount[curindex]) {
                maxindex = curindex;
            }
        }
        return (char) (maxindex);
    }

    public static String print(int[] charcount) {
        // StringBuidler sb = new StringBuidler();
        String s = "[";
        for (int c = 97; c < charcount.length; c++) {
            if (charcount[c] != 0)
                s += (char) c + "=" + charcount[c] + ", ";

        }
        s += "]";
        return s;
    }
}