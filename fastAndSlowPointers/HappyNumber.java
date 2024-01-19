package fastAndSlowPointers;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2147483646;

        var result = isHappyNumber(n);
        System.out.println("ANSWER = " + result);
    }

    static int[] squares = new int[10];

    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < 10; i++) {
            squares[i] = (int) Math.pow(i, 2);
        }

        long fast = sumOfSquareOfDigits(n);
        if (fast == 1) {
            return true;
        }
        fast = sumOfSquareOfDigits(fast);
        long slow = sumOfSquareOfDigits(n);
        while (fast != slow) {
            if (fast == 1) {
                return true;
            }
            fast = sumOfSquareOfDigits(fast);
            if (fast == 1) {
                return true;
            }
            fast = sumOfSquareOfDigits(fast);
            slow = sumOfSquareOfDigits(slow);
        }
        return false;
    }

    public static long sumOfSquareOfDigits(long n) {
        // if (memory.containsKey(n)){
        // // System.out.println("return " + memory.get(n) + " for " + n);
        // return memory.get(n);
        // }
        long sum = 0;
        int d;
        long num = n;
        while (num > 0) {
            d = (int) (num % 10);
            sum = sum + squares[d];
            num = num / 10;
        }
        // memory.put(n,sum);
        // System.out.println("return " + memory.get(n) + " for " + n);
        return sum;
    }
}
