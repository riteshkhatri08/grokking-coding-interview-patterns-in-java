package twopointer;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = new int[] { 0, 1, 0, 1, 2, 2, 1, 0, 1, 2, 1, 0, 1, 2, 2, 2 };
        System.out.println("INPUT");
        colors = sortColors(colors);
        System.out.print("ANSWER = ");
        print(colors);

    }

    public static int[] sortColors(int[] colors) {
        int red = 0, white = 0, blue = colors.length - 1;
        while (blue > -1 && colors[blue] == 2) {
            blue--;
        }
        print(colors);
        while (red < colors.length && colors[red] == 0) {
            red++;
        }
        white = red;

        while (white <= blue) {
            if (colors[white] == 0) {
                colors[white] = colors[red];
                colors[red++] = 0;
            } else if (colors[white] == 1) {
                white++;
            } else if (colors[white] == 2) {
                colors[white] = colors[blue];
                colors[blue--] = 2;
            }
        }

        return colors;
    }

    public static void print(int[] colors) {
        for (int c : colors) {
            System.out.print(c + " ");
        }
        System.out.println("");
    }
}
