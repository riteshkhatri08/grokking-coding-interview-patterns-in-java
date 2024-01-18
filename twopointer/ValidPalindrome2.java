package twopointer;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "eeccccbebaeeabebccceea";
        var result = isPalindrome(s);
        System.out.println("ANSWER = " + result);
    }

    public static boolean isPalindrome(String s) {

        char[] charray = s.toCharArray();
        s = null;

        return checkPalindrome(charray, 0, charray.length - 1, false);

    }

    private static boolean checkPalindrome(char[] charray, int left, int right, boolean switched) {
        while (left < right) {
            if (charray[left++] != charray[right--]) {
                if (switched) {
                    return false;
                } else {
                    if (charray[left - 1] == charray[right]) {

                        if (checkPalindrome(charray, left - 1, right, true)) {
                            return true;
                        } else if (charray[left] == charray[right + 1]) {
                            if (checkPalindrome(charray, left, right + 1, true)) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else if (charray[left] == charray[right + 1]) {
                        if (checkPalindrome(charray, left, right + 1, true)) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
