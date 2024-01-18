package twopointer;

public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "eeccccbebaeeabebccceea";
        var result = isPalindrome(s);
        System.out.println("ANSWER = " + result);
    }

    public static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return (checkPal(s, left - 1, right) || checkPal(s, left, right + 1)) ? true : false;
            }
        }
        return true;
    }

    private static boolean checkPal(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
