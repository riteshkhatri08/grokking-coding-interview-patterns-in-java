// https://leetcode.com/problems/basic-calculator/submissions/1184698109/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/basic-calculator

package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class BasicCalculator {

    public static void main(String[] args) {
        // System.out.println(300000/11);

        String input = "12 - 23  - (34 + 15) + 50";
        System.out.println("Result= " + new BasicCalculator().calculator(input));

    }

    static final int POSITION_OFFSET = 200;
    int position = 0;

    public int calculator(String expression) {
        char[] charray = expression.toCharArray();
        expression = null;
        // Stack to store ops
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        // store operands in this array
        // int [] arr = new int[27273];
        // we can have a valid expression with a maximum of 15000
        // int[] operands = new int[15000];
        ArrayList<Integer> operands = new ArrayList<Integer>();
        // store temp parsedO number
        int tempNumber = 0;
        // flag to see if a number has been recorded and is to be added to array
        boolean flag = false;

        for (char op : charray) {
            System.out.println("INPUT = " + op);
            switch (op) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0': {

                    if (flag == false) {
                        // Update temp number
                        flag = true;
                    }
                    tempNumber = tempNumber * 10 + (op - '0');
                    break;
                }
                case '+':
                case '-':
                case '(': {
                    // need to record temp number
                    if (flag) {
                        flag = false;
                        addNumberToStack(stack, operands, tempNumber);
                        tempNumber = 0;
                    }
                    // Now add actual '+ or - or (' operand that came in
                    stack.push(op);
                    break;
                }

                case ')': {
                    if (flag) {
                        flag = false;
                        addNumberToStack(stack, operands, tempNumber);
                        tempNumber = 0;
                    }
                    // when encountered a ')' starting popping elements and evaluate the expression
                    // until you see opening paranthesis '(';
                    // push this reseult of evauluated paranthesis back in stack
                    addNumberToStack(stack, operands, evaluate(stack, operands));
                    break;
                }
                case ' ': {
                    if (flag) {
                        flag = false;
                        addNumberToStack(stack, operands, tempNumber);
                        tempNumber = 0;
                    }
                    break;
                }

            }

            // print stack
            printStack(stack, operands);
        }
        if (flag) {
            flag = false;
            addNumberToStack(stack, operands, tempNumber);
            tempNumber = 0;
        }
        return evaluate(stack, operands);

    }

    private void printStack(ArrayDeque<Character> stack, ArrayList<Integer> operands) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Iterator<Character> itr = stack.iterator();
        char c;
        while (itr.hasNext()) {
            c = itr.next();
            switch (c) {
                case '+':
                case '-':
                case '(':
                case ')': {
                    sb.append(c).append(", ");
                    break;
                }
                default: {
                    sb.append(operands.get(c - POSITION_OFFSET)).append(", ");
                    break;
                }
            }
        }
        sb.append(" ]");
        System.out.println("STACK : " + sb.toString());
    }

    private void addNumberToStack(ArrayDeque<Character> stack, ArrayList<Integer> operands, int tempNumber) {

        // Check if previous element in stack is "-"
        if (!stack.isEmpty() && stack.peek() == '-') {

            // change current number to negative
            tempNumber = -1 * tempNumber;

            // change element at top of stack to '+' as we have consumed the "-"
            stack.pop();
            stack.push('+');
        }
        System.out.println("ADDING NUMBER: " + tempNumber);
        // store at given position in array

        if (operands.size() <= position) {
            operands.add(tempNumber);
        } else {
            operands.set(position, tempNumber);
        }
        // reset temp number to 0
        tempNumber = 0;
        System.out.println("PUSHING IN STACK: " + (char) (position + POSITION_OFFSET));

        // now add some offset to this postion and record it in stack
        stack.push((char) (position + POSITION_OFFSET));

        // Increment position for next available number
        position++;
    }

    private int evaluate(ArrayDeque<Character> stack, ArrayList<Integer> operands) {

        boolean flagRightOperand = false;
        int rightOperand = -1, leftOperand = -1;
        char operator = ' ';
        while (!stack.isEmpty() && !(stack.peek() == '(')) {
            char current = stack.pop();
            switch (current) {

                case '+':
                case '-': {
                    operator = current;
                    break;
                }

                default: {
                    // NUMBER
                    if (flagRightOperand == false) {

                        rightOperand = operands.get(current - POSITION_OFFSET);
                        position--;
                        flagRightOperand = true;
                    } else {
                        leftOperand = operands.get(current - POSITION_OFFSET);
                        position--;
                        switch (operator) {
                            case '+': {
                                System.out.println("OPERATION: " + rightOperand + " + " + leftOperand);
                                rightOperand = rightOperand + leftOperand;
                                break;
                            }
                            case '-': {
                                System.out.println("OPERATION -" + rightOperand + " - " + leftOperand);
                                rightOperand = rightOperand - leftOperand;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        if (!stack.isEmpty() && (stack.peek() == '(')) {
            // remove this bracket
            stack.pop();
        }

        return rightOperand;
    }
}
