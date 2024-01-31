package modifiedBinarySearch;

public class IsBadVersion {
    static int badversion = 10;

    public static void main(String[] args) {
        var answer = firstBadVersion(badversion);
        System.out.println("ANSWER =" + answer[0] + " " + answer[1]);
    }

    public static int[] firstBadVersion(int right) {
        int[] answer = new int[] { 0, 0 };
        int left = 1;
        while (left < right) {
            // IMportant to calculate mean;
            answer[0] = left + (right - left) / 2;
            answer[1]++;
            if (isBadVersion(answer[0])) {
                // Move in left sub array
                right = answer[0];
            } else {
                // Move in right sub array
                left = answer[0] + 1;
            }
        }
        answer[0] = right;
        return answer;
    }

    public static boolean isBadVersion(int a) {
        return a >= badversion ? true : false;
    }
}
