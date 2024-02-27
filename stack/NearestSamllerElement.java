// https://www.geeksforgeeks.org/problems/smallest-number-on-left3403
package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NearestSamllerElement {

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 3, 4, 5, 6, 7, 3, 2, 1 };
        System.out.println("ANSWER = " + new NearestSamllerElement().leftSmaller(arr.length, arr));

    }

    static List<Integer> leftSmaller(int n, int arr[]) {
        ArrayList<Integer> answers = new ArrayList<Integer>();
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        // start iterating from i = 1;
        // for i = 1 there is no element > i;
        answers.add(-1);
        stack.push(arr[0]);
        for (int i = 1; i < n; i++) {

            // Check while peek is smaller than current elemnt or ither stack is empty
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                // if stack is not empty , set peek as answer[i] else -1
                answers.add(-1);

            } else {
                // push current element in stack of stack is empty
                answers.add(stack.peek());
            }
            stack.push(arr[i]);
            // System.out.println("NUM="+arr[i]+" ,STACK = " + stack);
        }

        return answers;
    }
}
