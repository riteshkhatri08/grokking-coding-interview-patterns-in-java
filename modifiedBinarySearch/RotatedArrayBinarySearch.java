package modifiedBinarySearch;

import java.util.Arrays;
import java.util.List;

public class RotatedArrayBinarySearch {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2);
        int target = 2;
        int result = binarySearchRotated(input, target);
        System.out.println("ANSWER = " + result);
    }

    public static int binarySearchRotated(List<Integer> nums, int target) {
        if (nums.size() == 1) {
            if (nums.get(0) == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int left1 = 1, right2 = nums.size() - 2, right1 = -1, left2 = -1;
        // Check only if left1 is greater than right2
        // this means array has been rotated atleast once;
        if (nums.get(left1) > nums.get(right2)) {

            // Find Rotation Point by using pointers from both sides, for fast search
            while (right2 >= left1) {
                if (nums.get(left1) < nums.get(left1 - 1)) {
                    right1 = left1 - 1;
                    left2 = left1;
                    break;
                    // This is rotation point
                } else if (nums.get(right2) > nums.get(right2 + 1)) {
                    right1 = right2;
                    left2 = right2 + 1;
                    break;
                }
                right2--;
                left1++;
            }
            if (right2 < left1) {
                if (nums.get(left1) < nums.get(right2)) {
                    right1 = right2;
                    left2 = left1;
                }
            }
            right2 = nums.size() - 1;
            left1 = 0;
            // Now if target is greater than element at left 1 that means it is in first sub
            // array else it is in second hafl
            // do a binary search on which ever half it is present in ;
            if (target >= nums.get(left1)) {
                if (target == nums.get(left1)) {
                    return left1;
                } else {
                    // do binary search from left1 to right1
                    return binarySearch(left1, right1, nums, target);
                }
            } else {
                // do a binarysearch from left2 to right2
                return binarySearch(left2, right2, nums, target);
            }

        } else {
            // DO normal binary search on complete array
            return binarySearch(0, nums.size() - 1, nums, target);
        }

    }

    private static int binarySearch(int left, int right, List<Integer> nums, int target) {
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println("mid = " + nums.get(mid) + " target = " + target);
            if (target == nums.get(mid)) {
                return mid;
            } else if (target < nums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
