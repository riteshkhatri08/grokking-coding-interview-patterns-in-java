// https://leetcode.com/problems/largest-rectangle-in-histogram/

package stack;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stackLeft = new ArrayDeque<Integer>();
        ArrayDeque<Integer> stackRight = new ArrayDeque<Integer>();
        int left = 0, right = heights.length - 1;
        int areaLeft = 0, areaRight = 0, maxArea = 0;
        int[] nsl = new int[heights.length];
        int[] nsr = new int[heights.length];
        for (; left < heights.length;) {

            // FOR LEFT STACK
            while (!stackLeft.isEmpty() && (heights[stackLeft.peek()] > heights[left])) {
                stackLeft.pop();
            }

            nsl[left] = stackLeft.isEmpty() ? -1 : stackLeft.peek();
            stackLeft.push(left++);

            // FOR RIGHT STACK
            while (!stackRight.isEmpty() && (heights[stackRight.peek()] > heights[right])) {
                stackRight.pop();
            }
            nsr[right] = stackRight.isEmpty() ? heights.length : stackRight.peek();
            stackRight.push(right--);

            areaLeft = (nsr[left] - nsl[left] - 1) * heights[left];
            areaRight = (nsr[left] - nsl[left] - 1) * heights[left];
            if (areaLeft > areaRight && areaLeft > maxArea) {
                maxArea = areaLeft;
            } else if (areaRight > maxArea) {
                maxArea = areaRight;
            }
        }
        return maxArea;
    }
}
