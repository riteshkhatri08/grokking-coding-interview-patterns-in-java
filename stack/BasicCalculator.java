// https://leetcode.com/problems/basic-calculator/submissions/1184698109/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/basic-calculator

package stack;

public class BasicCalculator {

    public static void main(String[] args) {
        // System.out.println(300000/11);

        String input = "- (3 + (4 + 5))";
        System.out.println("Result= " + new BasicCalculator().calculate(input));

    }

    int index = 0;

    public int calculate(String expression) {
        return solve(expression.toCharArray());

    }

    private int solve(char[] charray) {
        char cur;
        int res = 0;
        int sign = 1;
        int temp = 0;

        for (; index < charray.length; index++) {
            cur = charray[index];
            switch (cur) {
                case '+': {
                    sign = 1;
                    break;

                }
                case '-': {
                    sign = -1;
                    break;
                }
                case ')': {
                    return res;
                }
                case '(': {
                    index++;
                    int a = solve(charray);
                    res += (sign * a);
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    temp = 0;
                    // NUMBER
                    for (; index < charray.length; index++) {
                        if (charray[index] >= '0' && charray[index] <= '9') {
                            temp = temp * 10 + (charray[index] - '0');
                        } else {
                            break;
                        }
                    }
                    temp = temp * sign;
                    res += temp;
                    if (index < charray.length) {
                        index--;
                    }
                }
            }
        }
        return res;
    }

}
