// https://www.codingninjas.com/studio/problems/stock-span_5243295
package stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpan {

    public static void main(String[] args) {
        int price[] = new int[] { 10, 20, 40, 20, 80, 75, 70, 200 };
        String ans = Arrays.stream(findStockSpans(price)).mapToObj(a -> a + "").reduce((x, y) -> x + "" + y).get();
        System.out.println("ANSWER = " + ans);
    }

    public static int[] findStockSpans(int[] price) {
        // Your code here

        int[] answer = new int[price.length];
        answer[0] = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        for (int i = 1; i < price.length; i++) {
            // System.out.println("i="+price[i] + " STACK = " + stack);
            // look for largest element in top of stack
            while (!stack.isEmpty() && price[stack.peek()] < price[i]) {

                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = i - 0 + 1;
            } else {
                answer[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return answer;
    }
}
