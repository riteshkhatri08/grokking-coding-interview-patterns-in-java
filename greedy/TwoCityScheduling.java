// https://leetcode.com/problems/two-city-scheduling/submissions/1183199176/
// https://www.codingninjas.com/studio/problems/two-city-scheduling_1386555?leftPanelTabValue=SUBMISSION
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/two-city-scheduling
package greedy;

import java.util.Arrays;

public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };

        System.out.println("RESULT = " + twoCityScheduling(costs));
    }

    public static int twoCityScheduling(int[][] costs) {
        // Replace this placeholder return statement with your code

        Arrays.sort(costs, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        // for (int[] is : costs) {
        // System.out.println(is[0] + " " + is[1]);
        // }
        long cost = 0;
        int a = 0;
        for (int i = costs.length / 2; i < costs.length; i++) {
            cost += costs[i][0];
            cost += costs[a++][1];
        }

        return (int) cost;
    }

}
