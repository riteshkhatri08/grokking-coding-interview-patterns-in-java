// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

package stack;

import java.util.ArrayDeque;

public class NextGreaterElement {

    public static void main(String[] args) {
        long arr[] = new long[] {
                7, 8, 1, 4
                // 1, 3, 2, 4

        };
        var result = new NextGreaterElement().nextLargerElement(arr, arr.length);
        System.out.print("ANSWER = [");
        for (long lo : result) {
            System.out.print(lo + ", ");
        }
        System.out.println("]");
    }

    public long[] nextLargerElement(long[] nums, int n) {
        long[] answers = new long[nums.length];
        ArrayDeque<Long> stack = new ArrayDeque<Long>();

        stack.push(nums[nums.length - 1]);
        answers[nums.length - 1] = -1L;

        for (int i = nums.length - 2; i > -1; i--) {
            System.out.println("NUM = " + nums[i] + " , BEFORE STACK = " + stack);
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                answers[i] = -1;
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    answers[i] = -1;
                    stack.push(nums[i]);
                } else {
                    answers[i] = stack.peek();
                    stack.push(nums[i]);

                }
            }
            System.out.println("NUM = " + nums[i] + " , AFTER STACK = " + stack);

        }

        return answers;
    }
}
