// https://leetcode.com/problems/basic-calculator/submissions/1184698109/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/basic-calculator

package stack;

import java.util.ArrayDeque;

public class BasicCalculator {

    public static void main(String[] args) {
        String input = "12 - (6 + 2) + 5";
        System.out.println("Result= " + calculator(input));
    }

    public static int calculator(String expression) {
        ArrayDeque<String> stack = new ArrayDeque<String>();

        char[] charray = expression.toCharArray();

        int temp = -1;
        int resultSoFar = 0;
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
                    {
                        if (temp == -1)
                            temp = 0;
                        temp = temp * 10 + (op - '0');
                        System.out.println(op);
                        break;

                    }
                }

                case '+': {
                    if (temp != -1) {
                        if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                            stack.pop();
                            stack.push("+");
                            temp = 0 - temp;
                        }
                        System.out.println("temp=" + temp);
                        stack.push(temp + "");
                        temp = -1;
                    }
                    System.out.println("pushing = +");
                    stack.push("+");

                    break;
                }

                case '-': {
                    if (temp != -1) {
                        if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                            stack.pop();
                            stack.push("+");
                            temp = 0 - temp;
                        }
                        System.out.println("temp=" + temp);
                        stack.push(temp + "");
                        temp = -1;
                    }
                    System.out.println("pushing = -");
                    stack.push("-");

                    break;
                }
                case '(': {
                    if (temp != -1) {
                        if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                            stack.pop();
                            stack.push("+");
                            temp = 0 - temp;
                        }
                        System.out.println("temp=" + temp);
                        stack.push(temp + "");
                        temp = -1;
                    }
                    System.out.println("pushing = (");
                    stack.push("(");
                    break;
                }
                case ')': {
                    // DO POPPING HERE
                    if (temp != -1) {
                        if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                            stack.pop();
                            stack.push("+");
                            temp = 0 - temp;
                        }
                        System.out.println("temp=" + temp);
                        stack.push(temp + "");
                        temp = -1;
                    }
                    System.out.println("pushing = )");
                    // stack.push(")");
                    resultSoFar = evaluate(stack, resultSoFar);
                    if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                        stack.pop();
                        stack.push("+");
                        resultSoFar = 0 - resultSoFar;
                    }
                    stack.push(resultSoFar + "");
                    break;
                }
                case ' ': {
                    if (temp != -1) {
                        if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                            stack.pop();
                            stack.push("+");
                            temp = 0 - temp;
                        }
                        System.out.println("temp=" + temp);
                        stack.push(temp + "");
                        temp = -1;
                    }
                    break;

                }

            }
            System.out.println("STACK - " + stack);
        }
        if (temp != -1) {
            if (!stack.isEmpty() && stack.peek().contentEquals("-")) {
                stack.pop();
                stack.push("+");
                temp = 0 - temp;
            }
            System.out.println("temp=" + temp);
            stack.push(temp + "");
            temp = -1;
        }
        int result = evaluate(stack, resultSoFar);

        return result;
    }

    private static int evaluate(ArrayDeque<String> stack, int resultSoFar) {
        boolean flagRightOperand = false;
        int rightOperand = -1, leftOperand = -1;
        String operator = "";
        while (!stack.isEmpty() && !stack.peek().contentEquals("(")) {
            String current = stack.pop();
            switch (current) {

                case "+": {
                    operator = "+";
                    break;
                }
                case "-": {
                    operator = "-";
                    break;
                }
                default: {
                    // NUMBER
                    if (flagRightOperand == false) {
                        rightOperand = Integer.parseInt(current);
                        flagRightOperand = true;
                    } else {
                        leftOperand = Integer.parseInt(current);
                        switch (operator) {
                            case "+": {
                                System.out.println("OPERATION: " + rightOperand + " + " + leftOperand);
                                rightOperand = rightOperand + leftOperand;
                                break;
                            }
                            case "-": {
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
        if (!stack.isEmpty() && stack.peek().contentEquals("(")) {
            stack.pop();
        }
        return rightOperand;
    }
}
