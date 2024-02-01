package modifiedBinarySearch;

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int nums[] = new int[] { 3, 3, 7, 7, 10, 11, 11 };
        System.out.println("Answer = " + singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (left != right) {
            mid = ((right + left) >> 1);
            System.out.println("LEFT=" + left + ", RIGHT=" + right + ", MID=" + mid);
            if (mid % 2 != 0) {
                if (nums[mid - 1] != nums[mid]) {
                    // MOVE LEFT
                    right = mid;
                } else {
                    // MOVE RIGHT
                    left = mid + 1;
                }
            } else {

                if (nums[mid] != nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
        }
        return nums[left];
    }
}
