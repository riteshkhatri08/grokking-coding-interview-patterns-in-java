// https://leetcode.com/problems/jump-game/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/jump-game-i

package greedy;

public class JumpGameOne {

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
        var result = new JumpGameOne().canJump(nums);
        System.out.println("Answer  = " + result);
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int target = nums.length - 1;
        int current = target - 1;
        while (current > -1) {
            if (current + nums[current] >= target) {
                target = current;
            }
            current--;
        }
        if (nums[current + 1] >= target) {
            return true;
        }
        return false;
    }
}
