package stack;

import java.util.ArrayDeque;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        var answer = trapWater(heights);
        System.out.println("ANSWER = " + answer);
    }

    private static int trapWater(int[] heights) {
        int waterTrapped = 0;
        int result = 0, left = 0, right = heights.length - 1;
        int[] ngl = new int[heights.length];
        int[] ngr = new int[heights.length];
        ArrayDeque<Integer> leftStack = new ArrayDeque<Integer>();
        ArrayDeque<Integer> rightStack = new ArrayDeque<Integer>();

        // Iterate half array without calculating diff b/w ngl and ngr
        while (right > left) {
            while (!leftStack.isEmpty() && leftStack.peek() < heights[left])
                leftStack.pop();

            if (leftStack.isEmpty()) {
                ngl[left] = -1;
                leftStack.push(heights[left]);
            } else {
                ngl[left] = leftStack.peek();
            }
            left++;
            // ngl[left] = leftStack.isEmpty() ? -1 : leftStack.peek();
            // leftStack.push(heights[left++]);

            while (!rightStack.isEmpty() && rightStack.peek() < heights[right])
                rightStack.pop();

            if (rightStack.isEmpty()) {
                ngr[right] = -1;
                rightStack.push(heights[right]);
            } else {
                ngr[right] = rightStack.peek();
            }
            right--;
            // ngr[right] = rightStack.isEmpty() ? -1 : rightStack.peek();
            // rightStack.push(heights[right--]);
        }

        int curTrap = 0;
        int curHeight = 0;

        if (right == left) {
            while (!leftStack.isEmpty() && leftStack.peek() < heights[left])
                leftStack.pop();
            if (leftStack.isEmpty()) {
                ngl[left] = -1;
                leftStack.push(heights[left]);
            } else {
                ngl[left] = leftStack.peek();
            }

            while (!rightStack.isEmpty() && rightStack.peek() < heights[right])
                rightStack.pop();
            if (rightStack.isEmpty()) {
                ngr[right] = -1;
                rightStack.push(heights[right]);
            } else {
                ngr[right] = rightStack.peek();
            }

            if (ngr[left] > 0 && ngl[left] > 0) {
                curHeight = ngl[left] > ngr[left] ? ngr[left] : ngl[left];
                curTrap = curHeight - heights[left];
                waterTrapped += curTrap;
            }
            left++;
            right--;
        }

        // repeat second half , but this time calculate water trapping
        while (right > -1) {
            while (!leftStack.isEmpty() && leftStack.peek() < heights[left])
                leftStack.pop();
            if (leftStack.isEmpty()) {
                ngl[left] = -1;
                leftStack.push(heights[left]);
            } else {
                ngl[left] = leftStack.peek();
            }

            while (!rightStack.isEmpty() && rightStack.peek() < heights[right])
                rightStack.pop();
            if (rightStack.isEmpty()) {
                ngr[right] = -1;
                rightStack.push(heights[right]);
            } else {
                ngr[right] = rightStack.peek();
            }

            if (ngr[right] > 0 && ngl[right] > 0) {
                curHeight = ngl[right] > ngr[right] ? ngr[right] : ngl[right];
                curTrap = curHeight - heights[right];
                waterTrapped += curTrap;
            }

            if (ngr[left] > 0 && ngl[left] > 0) {
                curHeight = ngl[left] > ngr[left] ? ngr[left] : ngl[left];
                curTrap = curHeight - heights[left];
                waterTrapped += curTrap;
            }
            right--;
            left++;
        }
        printArray("NGL", ngl);
        printArray("NGR", ngr);
        return waterTrapped;
    }

    public static void printArray(String message, int arr[]) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append('=');
        sb.append('[');

        for (int a : arr) {
            sb.append(a).append(' ');
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

}
