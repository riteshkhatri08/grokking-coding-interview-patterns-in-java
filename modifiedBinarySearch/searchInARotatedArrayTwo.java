package modifiedBinarySearch;

public class searchInARotatedArrayTwo {

    public static void main(String[] args) {
        int arr[] = new int[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1 };
        System.out.println("ANSWER = " + search(arr, 2));
    }

    public static boolean search(int[] arr, int t) {

        int pivot = findPivot(0, arr.length - 1, arr);
        boolean result = false;
        // if pivot is -1 then array is sorted broooo
        if (pivot != -1) {
            System.out.println("PIVOT = " + arr[pivot]);

            if (t >= arr[0]) {

                result = binarySearch(0, pivot, t, arr);
            } else {
                result = binarySearch(pivot + 1, arr.length - 1, t, arr);
            }
        } else {
            System.out.println("ARRAY IS SORTED AND UNROTATED");
            result = binarySearch(0, arr.length - 1, t, arr);
        }

        return result;
    }

    private static boolean binarySearch(int left, int right, int t, int[] arr) {
        int mid = 0;
        System.out.println("SEARCHING T=" + t + " IN " + left + " to " + right);
        while (right >= left) {
            mid = (left + right) >> 1;
            System.out.println("left=" + left + ", right=" + right + ", mid=" + mid);
            System.out.println("[left]=" + arr[left] + ", [right=]" + arr[right] + ", [mid]=" + arr[mid]);
            if (arr[mid] == t) {
                return true;
            } else if (arr[mid] > t) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    private static int findPivot(int left, int right, int[] arr) {

        System.out.println("SEARCHING PIVOT IN " + left + " to " + right);
        int mid = (left + right) >> 2, rightoriginal = right;
        while (right >= left) {
            mid = (right + left) >> 1;
            System.out.println("left=" + left + ", right=" + right + ", mid=" + mid);
            if (mid != rightoriginal && arr[mid] > arr[mid + 1]) {
                // THIS IS PIVOT RETURN IT
                return mid;
            } else {
                // COMPARE CURRENT ELEMENT WITH 0th element ,
                if (arr[mid] < arr[0]) {
                    // THIS MEANS PIVOT ELEMENT IS ON OUR LEFT SIDE
                    // SO MOVE TO LEFT SUB ARRAY
                    right = mid - 1;
                } else if (arr[mid] > arr[0]) {
                    // THIS MEANS PIVOT ELEMENT IS ON OUR RIGHT SIDE
                    // SO MOVE TO RIGHT SUB ARRAY
                    left = mid + 1;
                } else {
                    // arr[mid] == arr[0]
                    // DAMN WE CANT TELL PIVOT IS ON OUR LEFT OR RIGHT ,
                    // GO SEARCH FOR PIVOT IN BOTH ARRAYS
                    System.out.println("TIME FOR RECURSIV SEARCH ");
                    // SEARCH IN LEFT
                    int p1 = findPivot(left, mid - 1, arr);
                    // SEARCH IN RIGHT
                    int p2 = findPivot(mid + 1, right, arr);
                    System.out.println("RESULT FROM RECURSIVE SEARCH p1=" + p1 + " p2=" + p2);
                    if (p1 == -1 && p2 == -1) {
                        return -1;
                    } else {
                        mid = p1 == -1 ? p2 : p1;
                        break;
                    }
                }
            }
        }
        if (mid == rightoriginal) {
            // IF MID IS EQUAL TO RIGHT , THIS ARRAY IS DAMN SORTED return -1
            return -1;
        }
        System.out.println("BEFORE RETURNING MID = " + arr[mid] + " MID+1 = " +
                arr[mid + 1]);
        if (arr[mid] <= arr[mid + 1]) {
            return -1;
        } else {
            // YO MID IS GOOD
            return mid;
        }
    }
}
