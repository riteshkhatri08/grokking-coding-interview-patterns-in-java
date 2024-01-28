package modifiedBinarySearch;

public class BinarySearch {
    static int[] nums = null;
    static int target = 0;

    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 9, 9, 10, 11, 12, 143, 222 };
        int target = 222;
        var answer = binarySearch(nums, target);
        System.out.println("ANSWER = " + answer);
    }

    public static int binarySearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid = 0;
        while ((left <= right)) {
            mid = (right + left) / 2;
            if (nums[mid] > target) {
                // Check in left sub array
                right = mid - 1;
            } else if (nums[mid] < target) {
                // check in right sub array
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // public static int helper(int left, int right) {
    // if (right < left) {
    // return -1;
    // }
    // // Calculate middle
    // int mid = (right + left) / 2;

    // if (nums[mid] > target) {

    // // Check in left sub array
    // return helper(left, mid - 1);

    // } else if (nums[mid] < target) {
    // // check in right sub array
    // return helper(mid + 1, right);
    // } else {
    // return mid;
    // }

    // }
}