package dfs;

import java.util.ArrayDeque;

class Pair {

    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FindNoOfIslands {

    public static void main(String[] args) {
        char[][] input = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

        var result = new FindNoOfIslands().numIslands(input);
        System.out.println("ANSWER = " + result);
    }

    public int numIslands(char[][] grid) {
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0, newx, newy, i;
        ArrayDeque<Pair> stack = new ArrayDeque<Pair>();
        Pair current;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] == '1') {
                    // System.out.println(" ***** STARTING A NEW GRID AT " + m + "," + n);
                    stack.push(new Pair(m, n));
                    while (!stack.isEmpty()) {
                        current = stack.pop();

                        // System.out.println(
                        // "CHECKING - " + current.x + " " + current.y + " value = " +
                        // grid[current.x][current.y]);
                        // Check all directions

                        // System.out.println("MARK VISITED = " + current.x + "," + current.y);
                        for (i = 0; i < directions.length; i++) {
                            newx = current.x + directions[i][0];
                            newy = current.y + directions[i][1];
                            // System.out.println("new coordinates = " + newx + "," + newy);
                            if (newx > -1
                                    && newx < grid.length
                                    && newy > -1
                                    && newy < grid[0].length
                                    && grid[newx][newy] == '1') {
                                grid[newx][newy] = '0';
                                stack.push(new Pair(newx, newy));
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
