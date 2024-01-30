// https://leetcode.com/problems/search-in-rotated-sorted-array/
// https://www.codingninjas.com/studio/problems/search-in-rotated-sorted-array_1082554?leftPanelTabValue=SUBMISSION
// https://www.educative.io/courses/grokking-coding-interview-patterns-java/search-in-rotated-sorted-array

package modifiedBinarySearch;

public class RotatedArrayBinarySearch {
    public static void main(String[] args) throws Exception {
        // List<Integer> input = Arrays.asList(-9996, -9941, 1);
        // int target = 20;
        int[] input = new int[] { 3, 1 };
        for (int i = 0; i < input.length; i++) {
            System.out.println("=====================\nSearching for " + input[i]);
            int result = new RotatedArrayBinarySearch().search(input, input[i]);
            if (i != result) {
                throw new Exception("RESULT and EXPECTED MISMATCH");
            }
            System.out.println("ANSWER = " + result);
        }
    }

    //

    // Use binary search to find pivot
    // if target < = left and <= pivot find in left arrat else in right array
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int pivot = findPivot(nums);
        if (pivot >= 0) {

            if (target >= nums[0]) {
                return binarySearch(0, pivot, nums, target);
            } else {
                return binarySearch(pivot + 1, nums.length - 1, nums, target);
            }

        } else {
            return binarySearch(0, nums.length - 1, nums, target);
        }
    }

    private static int findPivot(int[] nums) {

        int left = 0, right = nums.length - 1, mid, n = right;

        while (left <= right) {
            mid = (left + right) / 2;
            // EDGE CASE 1
            if (mid == 0) {
                if (nums[mid] <= nums[mid + 1]) {
                    return -1;
                } else {
                    return mid;
                }
            }
            // EDGE CASE 2
            if (mid == n) {
                if (nums[mid] <= nums[mid - 1]) {
                    return mid - 1;
                } else {
                    return -1;
                }
            }

            // Left of mid greater than mid
            if (nums[mid - 1] > nums[mid]) {
                // THEN mid -1 is pivot
                return mid - 1;
            } else if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    private static int binarySearch(int left, int right, int[] nums, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
