package stack;

import java.util.ArrayDeque;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][] {};

        var answer = new MaximalRectangle().maximalRectangle(matrix);
        System.out.println("ANSWER = " + answer);
    }

    public int maximalRectangle(char[][] matrix) {

        int[] arr = new int[matrix[0].length];
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];
        ArrayDeque<Integer> stackLeft = new ArrayDeque<Integer>();
        ArrayDeque<Integer> stackRight = new ArrayDeque<Integer>();
        int curAreaA = 0, curAreaB = 0;
        int maxArea = 0;
        int k, j;

        for (int i = 0; i < matrix.length; i++) {
            // System.out.println("NEW ROW - "+ i);
            k = arr.length - 1;
            j = 0;
            curAreaA = 0;
            curAreaB = 0;

            stackLeft.clear();
            stackRight.clear();
            while (k > j) {
                arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + (matrix[i][j] - '0');
                arr[k] = matrix[i][k] == '0' ? 0 : arr[k] + (matrix[i][k] - '0');

                while (!stackLeft.isEmpty() && (arr[stackLeft.peek()] >= arr[j])) {
                    stackLeft.pop();
                }
                if (stackLeft.isEmpty()) {
                    nsl[j] = -1;
                } else {
                    nsl[j] = stackLeft.peek();
                }
                stackLeft.push(j);
                // nsr
                while (!stackRight.isEmpty() && (arr[stackRight.peek()] >= arr[k])) {
                    stackRight.pop();
                }
                if (stackRight.isEmpty()) {
                    nsr[k] = arr.length;
                } else {
                    nsr[k] = stackRight.peek();
                }
                stackRight.push(k);
                j++;
                k--;
            }

            if (j == k) {
                arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + (matrix[i][j] - '0');
            }

            while (j < arr.length) {

                while (!stackLeft.isEmpty() && (arr[stackLeft.peek()] >= arr[j])) {
                    stackLeft.pop();
                }
                if (stackLeft.isEmpty()) {
                    nsl[j] = -1;
                } else {
                    nsl[j] = stackLeft.peek();
                }
                stackLeft.push(j);
                // nsr
                while (!stackRight.isEmpty() && (arr[stackRight.peek()] >= arr[k])) {
                    stackRight.pop();
                }
                if (stackRight.isEmpty()) {
                    nsr[k] = arr.length;
                } else {
                    nsr[k] = stackRight.peek();
                }
                stackRight.push(k);

                curAreaA = (nsr[j] - nsl[j] - 1) * arr[j];
                curAreaB = (nsr[k] - nsl[k] - 1) * arr[k];
                if (curAreaA > curAreaB) {
                    if (curAreaA > maxArea) {
                        maxArea = curAreaA;
                    }
                } else {
                    if (curAreaB > maxArea) {
                        maxArea = curAreaB;
                    }
                }
                j++;
                k--;
            }
        }
        return maxArea;
    }

}
