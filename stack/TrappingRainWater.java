package stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        var answer = trapWater(heights);
        System.out.println("ANSWER = " + answer);
    }

    private static int trapWater(int[] heights) {
        int waterTrapped = 0;
        int left = 0, right = heights.length - 1;
        int highLeft = -1;
        int highRight = -1;
        int[] ngl = new int[heights.length];
        int[] ngr = new int[heights.length];

        while (left < right) {
            // Left side first
            if (highLeft >= heights[left]) {
                ngl[left] = highLeft;
            } else {
                ngl[left] = -1;
                highLeft = heights[left];
            }
            left++;

            if (highRight >= heights[right]) {
                ngr[right] = highRight;
            } else {
                ngr[right] = -1;
                highRight = heights[right];
            }
            right--;
        }
        // Update center
        if (left == right) {

            if (highLeft >= heights[left]) {
                ngl[left] = highLeft;
            } else {
                ngl[left] = -1;
                highLeft = heights[left];
            }

            if (highRight >= heights[right]) {
                ngr[right] = highRight;
            } else {
                ngr[right] = -1;
                highRight = heights[right];
            }

            if (ngl[right] > 0 && ngr[right] > 0) {
                if (ngl[right] > ngr[right]) {
                    waterTrapped += ngr[right] - heights[right];
                } else {
                    waterTrapped += ngl[right] - heights[right];
                }
            }

            if (ngl[left] > 0 && ngr[left] > 0) {
                if (ngl[left] > ngr[left]) {
                    waterTrapped += ngr[left] - heights[left];
                } else {
                    waterTrapped += ngl[left] - heights[left];
                }
            }

            right--;
            left++;
        }

        while (left < heights.length) {
            if (highLeft >= heights[left]) {
                ngl[left] = highLeft;
            } else {
                ngl[left] = -1;
                highLeft = heights[left];
            }

            if (highRight >= heights[right]) {
                ngr[right] = highRight;
            } else {
                ngr[right] = -1;
                highRight = heights[right];
            }

            if (ngl[right] > 0 && ngr[right] > 0) {
                if (ngl[right] > ngr[right]) {
                    waterTrapped += ngr[right] - heights[right];
                } else {
                    waterTrapped += ngl[right] - heights[right];
                }
            }

            if (ngl[left] > 0 && ngr[left] > 0) {
                if (ngl[left] > ngr[left]) {
                    waterTrapped += ngr[left] - heights[left];
                } else {
                    waterTrapped += ngl[left] - heights[left];
                }
            }

            right--;
            left++;

        }

        // for (int i = 0; i < heights.length; i++) {
        //     if (ngl[i] > 0 && ngr[i] > 0) {
        //         if (ngl[i] > ngr[i]) {
        //             waterTrapped += ngr[i] - heights[i];
        //         } else {
        //             waterTrapped += ngl[i] - heights[i];
        //         }
        //     }
        // }
        // printArray("NGL", ngl);
        // printArray("NGR", ngr);
        return waterTrapped;
    }

    public static void printArray(String message, int arr[]) {
        StringBuilder sb = new StringBuilder();
        sb.append(message).append('=');
        sb.append('[');

        for (int a : arr) {
            sb.append(a).append(' ');
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

}
