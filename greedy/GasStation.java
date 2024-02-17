// https://leetcode.com/problems/gas-station/submissions/1177643124/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/gas-stations

package greedy;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[] { 4, 5, 6, 7, 8, 10, 1, 2, 3, 4 };
        int[] cost = new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4, 5 };
        var answer = gasStationJourney(gas, cost);
        System.out.println("ANSWER = " + answer);
    }

    public static int gasStationJourney(int[] gas, int[] cost) {
        int i = 0, startIndex = 0;
        long currentGas = 0;
        for (; i < gas.length; i++) {
            gas[i] = gas[i] - cost[i];
            // NEW ELEMENT HAS ARRIVED
            // Add it to currentGas
            currentGas += gas[i];
        }
        if (currentGas < 0) {
            return -1;
        }

        currentGas = 0;
        for (i = 0; i < gas.length; i++) {
            currentGas += gas[i];
            if (currentGas < 0) {
                currentGas = 0;
                // go to next point
                startIndex = i + 1;
            }
        }
        return startIndex;
    }
}
