// https://www.educative.io/courses/grokking-coding-interview-patterns-java/valid-palindrome

package twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "RACEAR";
        var output = validPalindrome(input);
        System.out.println("Answer = " + output);

    }

    private static boolean validPalindrome(String input) {
        char charray[] = input.toCharArray();
        int left = 0, right = charray.length - 1;
        while (left < right) {
            if (charray[left++] != charray[right--])
                return false;
        }
        return true;
    }

}
