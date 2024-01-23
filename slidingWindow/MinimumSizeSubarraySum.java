package slidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int tarrget = 5;
        int[] nums = new int[] { 1, 1, 1 };
        System.out.println("ANSWER = " + minSubArrayLen(tarrget, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE, left = 0, right = 0;
        while (right < nums.length) {
            // New number comes in subtract it from target
            target -= nums[right];

            // reached min required sum
            while (target <= 0) {
                if ((right - left + 1) < minlen) {
                    minlen = right - left + 1;
                }
                target += nums[left];
                left++;
            }
            right++;
        }

        if (minlen == Integer.MAX_VALUE) {
            minlen = 0;
        }
        return minlen;
    }
}
