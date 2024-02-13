package modifiedBinarySearch;

// FIND first num > target;

// FOUND MID now time to find k elements
import java.util.ArrayList;
import java.util.List;

public class KClosest {
    public static void main(String[] args) {
        int nums[] = new int[] { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };
        int k = 9;
        int target = 4;
        var result = findClosestElements(nums, k, target);
        System.out.println("ANSWER = " + result);
    }

    public static List<Integer> findClosestElements(int[] nums, int k, int target) {
        List<Integer> result = new ArrayList<Integer>();
        // FIND first num > target;

        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = (right + left) / 2;
            System.out.println("LEFT=" + left + ", RIGHT=" + right + ", MID=" + mid);
            if (mid != 0) {
                System.out.println("left dist = " + (Math.abs(target - nums[mid - 1])) + " right dist = "
                        + (Math.abs(target - nums[mid])));
            } else {
                System.out.println("mid is 0");
            }
            if (nums[mid] == target) {

                if (mid != 0 && ((Math.abs(target - nums[mid - 1])) < (Math.abs(target - nums[mid])))) {
                    mid = mid - 1;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // FOUND MID now time to find k elements
        System.out.println("MID =" + nums[mid]);

        left = mid - 1;
        right = mid + 1;
        result.add(nums[mid]);
        k--;
        while (k > 0) {
            if (left >= 0 && right < nums.length) {
                if (Math.abs(nums[mid] - nums[left]) <= Math.abs(nums[mid] - nums[right])) {
                    result.add(0, nums[left]);
                    System.out.println("ADDING " + nums[left]);
                    left--;
                } else {
                    result.add(nums[right]);
                    System.out.println("ADDING " + nums[right]);
                    right++;
                }

            } else if (left > -1) {
                result.add(0, nums[left]);
                System.out.println("ADDING " + nums[left]);
                left--;
            } else {
                result.add(nums[right]);
                System.out.println("ADDING " + nums[right]);
                right++;
            }
            k--;
        }
        return result;
    }
}