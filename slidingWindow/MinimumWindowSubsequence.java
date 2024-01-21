// https://www.codingninjas.com/studio/problems/minimum-window-subsequence_2181133?leftPanelTabValue=SUBMISSION
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/minimum-window-subsequence

package slidingWindow;
public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String s = "abcdbebe", t = "bbe";
        var result = minWindow(s, t);
        System.out.println("ANSWER = " + result);
    }

    public static String minWindow(String s, String t) {

        char charray[] = s.toCharArray();
        char tarray[] = t.toCharArray();
        int left = -1, right = 0;
        int smallestLeft = 0, smallestRight = Integer.MAX_VALUE;
        while (left < (charray.length - tarray.length)) {

            // System.out.println("LEFT = " + left);

            int tcur = 0;
            left++;
            while (left < charray.length) {
                if (charray[left] == tarray[tcur]) {
                    tcur++;
                    break;
                }
                left++;
            }
            // System.out.println("FOUND FIRST CHAR of tarray at LEFT=" + left);
            right = left + 1;
            while (right < charray.length) {
                if (charray[right] == tarray[tcur]) {
                    tcur++;
                    if (tcur >= tarray.length) {
                        right++;
                        break;
                    }
                }
                right++;
            }

            if (tcur == tarray.length) {
                // System.out.println("FOUND COMPLETE TARRAY FROM " + left + " TO " + (right - 1));
                // System.out.println((right - left) + " VS " +  (smallestRight - smallestLeft));
                if ((right - left) < (smallestRight - smallestLeft)) {
                    smallestLeft = left;
                    smallestRight = right;
                    // System.out.println("UPDATED  sl and sr = " + smallestLeft + " : " + smallestRight);
                }
            }
        }
        if (smallestRight == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(smallestLeft, smallestRight);
        }

    }

}