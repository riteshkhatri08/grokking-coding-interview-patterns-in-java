// https://www.educative.io/courses/grokking-coding-interview-patterns-java/find-maximum-in-sliding-window
// https://leetcode.com/problems/sliding-window-maximum/

package slidingWindow;

import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int nums[] = new int[] { 10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9,
                10, 34, 67 };

        // EXPECTED ANSWER = [10, 9, 23, 23, 34, 56, 67, 67, 67, -1, -2, 9, 10, 34, 67]
        int k = 3;
        var answer = findMaxSlidingWindow(nums, k);
        System.out.println("\n\n RESULT = ");
        for (int a : answer) {
            System.out.print(" " + a);
        }
        System.out.println("");
    }

    public static int[] findMaxSlidingWindow(int[] nums, int k) {

        LinkedList<Integer> dq = new LinkedList<Integer>();
        int[] answers = new int[nums.length - k + 1];
        int count = 0, i = 0;

        // Initialize window
        while (i < k) {
            addElement(dq, nums[i++]);
        }

        // NOW SLIDING TIME
        for (; i < nums.length; i++) {
            // GET TOP FIRST
            answers[count] = dq.peek();

            // Element at nums[count] must be rmoved from dq becuase window will slide
            if (nums[count++] == dq.peek()) {
                dq.poll();
            }
            // Add Element
            addElement(dq, nums[i]);
        }

        answers[count] = dq.peek();

        return answers;
    }

    public static void addElement(LinkedList<Integer> list, int element) {
        System.out.println("LOOKING TO ADD " + element);
        System.out.println("BEFORE: " + list);

        for (int j = list.size() - 1; j > -1; j--) {
            if (list.get(j) < element) {
                list.remove(j);
                // j--;
                // System.out.println("REMOVED" + a);
            } else {
                break;
            }
        }
        // for (int j = 0; j < list.size(); j++) {
        // if (list.get(j) < element) {
        // list.remove(j);
        // j--;
        // // System.out.println("REMOVED" + a);
        // }
        // }
        list.add(element);
        System.out.println("AFTER: " + list);
    }

}
