package greedy;
// https://leetcode.com/problems/boats-to-save-people/description/
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/boats-to-save-people


import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = new int[] { 1, 2, 3, 4 };
        int limit = 5;
        System.out.println("Answer =" + rescueBoats(people, limit));
    }
    // 12344

    public static int rescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int lower = 0, higher = people.length - 1, count = 0, cursum = 0, occupancy = 0;

        while (lower <= higher) {
            // sabse bhari aadmi ko bhitao
            cursum = people[higher];
            occupancy = 1;
            // aur jagah hai kya boat me ?
            if (cursum < limit) {

                // kya ek aur bhaari aadmi baith payega ?
                if (lower <= (higher - 1) && ((cursum + people[higher - 1]) <= limit)) {
                    higher--;
                    cursum += people[higher];
                    occupancy = 2;
                }
                // agar dusra bhari aadmi nahi baith paya toh
                // kya ek halka aadmi baith sakta hai ?
                if (occupancy < 2 && ((lower) <= higher) && ((cursum + people[lower]) <= limit)) {
                    cursum += people[lower];
                    lower++;
                }
                // Boat bhar gai bhai aur kitna baithaega
            }
            // aur jagah nahi hai agli boat aur agla aadmi lao
            count++;
            higher--;
        }
        return count;
    }

}