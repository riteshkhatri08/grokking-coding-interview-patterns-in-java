// https://www.educative.io/courses/grokking-coding-interview-patterns-java/sum-of-three-values
package twopointer;

import java.util.Arrays;

public class SumOfThreeValues {
    public static void main(String[] args) {
        int[] nums = new int[] { 0, -1, 1 };
        int target = 0;

        var output = findSumOfThree(nums, target);
        System.out.println("ANSWER = " + output);

    }

    public static boolean findSumOfThree(int[] nums, int target) {
        if (nums.length > 2) {
            Arrays.sort(nums);
            int cursum = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    cursum = nums[left] + nums[i] + nums[right];
                    if (cursum < target) {
                        left++;
                    } else if (cursum > target) {
                        right--;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
