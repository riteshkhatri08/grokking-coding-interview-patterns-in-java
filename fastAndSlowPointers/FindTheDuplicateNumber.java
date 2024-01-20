// https://www.educative.io/courses/grokking-coding-interview-patterns-java/find-the-duplicate-number
// https://leetcode.com/problems/find-the-duplicate-number/description/
package fastAndSlowPointers;

public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 1, 7 };
        var result = findDuplicate(arr);
        System.out.println("ANSWER = " + result);
    }

    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        // System.out.println("SLOW="+slow+", FAST="+fast);
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
            // System.out.println("SLOW="+slow+", FAST="+fast+", SLOWVAL="+nums[slow]+",
            // FASTVAL="+nums[fast]);
        } while (slow != fast);
        slow = 0;
        // Do one more cycle with same speed
        do {
            fast = nums[fast];
            slow = nums[slow];
        } while (slow != fast);

        return slow;
    }
}
