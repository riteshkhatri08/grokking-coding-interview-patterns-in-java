// https://www.educative.io/courses/grokking-coding-interview-patterns-java/repeated-dna-sequences
// https://leetcode.com/problems/repeated-dna-sequences/description

package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class RepeatedDNASequences {
    public static void main(String[] args) {
        String s = "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT";
        int k = 10;
        var answer = findRepeatedSequences(s, k);
        System.out.println("ANSWER = " + answer);
    }

    public static Set<String> findRepeatedSequences(String s, int k) {
        char[] charray = s.toCharArray();
        StringBuilder current = new StringBuilder();
        HashSet<String> substrings = new HashSet<String>();
        HashSet<String> answerset = new HashSet<String>();

        int i = 0;
        while (i < k - 1) {
            current.append(charray[i]);
            i++;
        }
        String temp;
        for (; i < charray.length; i++) {
            current.append(charray[i]);
            temp = current.toString();
            // System.out.println(temp);
            if (substrings.contains(temp)) {
                answerset.add(temp);
            } else {
                substrings.add(temp);
            }
            current.deleteCharAt(0);
        }

        return answerset;
    }
}
