// https://www.educative.io/courses/grokking-coding-interview-patterns-java/happy-number
// https://leetcode.com/problems/happy-number/

package fastAndSlowPointers;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2147483646;

        var result = isHappyNumber(n);
        System.out.println("ANSWER = " + result);

    }

    static int[] squares = new int[10];
    static long sum = 0;
    static int d = 0;
    static {
        squares[0] = 0;
        squares[1] = 1;
        squares[2] = 4;
        squares[3] = 9;
        squares[4] = 16;
        squares[5] = 25;
        squares[6] = 36;
        squares[7] = 49;
        squares[8] = 64;
        squares[9] = 81;
    }

    public static boolean isHappyNumber(int n) {

        long fast = n, slow = n;

        while (fast != 1) {
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));
            if (fast == 1 || slow == 1) {
                return true;
            } else if (fast == slow) {
                return false;
            }
        }

        return true;
    }

    public static long sumOfSquareOfDigits(long num) {
        // System.out.println("doing " + num);
        sum = 0;
        while (num > 0) {
            d = (int) (num % 10);
            sum = sum + squares[d];
            num = num / 10;
        }
        // System.err.println("RETURNING - " + sum);
        return sum;
    }
}
