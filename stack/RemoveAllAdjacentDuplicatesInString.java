// https://www.educative.io/courses/grokking-coding-interview-patterns-java/remove-all-adjacent-duplicates-in-string
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/1185027758/
package stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String input = "abbaca";
        var answer = new RemoveAllAdjacentDuplicatesInString().removeDuplicates(input);
        System.out.println("ANSWER = " + answer);

    }

    public String removeDuplicates(String s) {
        // Using stringbuilder as a stack
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (sb.length() == 0) {
                sb.append(c);
            } else {
                if (sb.charAt(sb.length() - 1) == c) {
                    sb.setLength(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
