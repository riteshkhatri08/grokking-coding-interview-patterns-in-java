// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/submissions/1185560999/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/minimum-remove-to-make-valid-parentheses
package stack;

public class MinimumRemovetoMakeValidParentheses {

    public static void main(String[] args) {
        String input = "lee(t(c)o)de)";
        var answer = new MinimumRemovetoMakeValidParentheses().minRemoveToMakeValid(input);
        System.out.println("ANSWER  = " + answer);

    }

    int index = 0;
    int openCount = 0;

    public String minRemoveToMakeValid(String s) {
        return helper(s.toCharArray()).toString();
    }

    private StringBuilder helper(char[] charray) {
        char cur;
        StringBuilder current = new StringBuilder();
        for (; index < charray.length; index++) {
            cur = charray[index];
            switch (cur) {
                case '(': {
                    index++;
                    openCount++;
                    // Go find a closing bracket at my level
                    current.append(helper(charray));
                    break;
                }
                case ')': {
                    if (openCount > 0) {
                        openCount--;
                        current.insert(0, '(');
                        current.append(')');
                        return current;
                    } else {
                        break;
                    }
                }
                default:
                    // regular string character just add it to what's to be returned now
                    current.append(cur);
                    break;
            }
        }
        return current;
    }
}
