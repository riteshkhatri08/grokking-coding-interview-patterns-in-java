package slidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;
        System.out.println("ANSWER = " + longestRepeatingCharacterReplacement(s, k));
    }

    public static int longestRepeatingCharacterReplacement(String s, int k) {

        int[] charcount = new int[26];

        int left = 0, right = 0, maxsofar = 0;

        // System.out.println("STRING = " + s);
        char[] charray = s.toCharArray();
        char maxchar = charray[left];

        // charcount.put(charray[left], 1);
        maxchar = charray[left];
        for (; right < charray.length; right++) {

            // System.out.println("NEW CHAR CAME IN - " + charray[right] + " , right=" +
            // right);
            charcount[charray[right] - 'A']++;

            // System.out.println("CHAR COUNT = " + charcount);

            // Check if current character same as max character
            if (maxchar != charray[right]) {

                // Check how many characters have we replaced already
                int replaced;
                if (charcount[maxchar - 'A'] < charcount[charray[right] - 'A']) {
                    maxchar = charray[right];

                    // System.out.println(" New max xhar " + maxchar);
                }
                replaced = right - left - charcount[maxchar - 'A'] + 1;

                // System.out.println("Replaced = " + replaced);
                while (replaced > k) {

                    // time to shrink window
                    charcount[charray[left] - 'A']--;
                    left++;

                    // System.out.println("decrease window, char count" + charcount + " , left=" +
                    // left);
                    if ((right - left + 1) > maxsofar) {
                        maxsofar = right - left + 1;
                    }
                    // Now get the new max char

                    maxchar = getMostRecurringCharacter(charcount);
                    replaced = right - left - charcount[maxchar - 'A'] + 1;

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

    public static char getMostRecurringCharacter(int[] charcount) {
        int maxindex = 0;
        for (int curindex = 0; curindex < charcount.length; curindex++) {
            if (charcount[maxindex] < charcount[curindex]) {
                maxindex = curindex;
            }
        }
        return (char) ('A' + maxindex);
    }
}