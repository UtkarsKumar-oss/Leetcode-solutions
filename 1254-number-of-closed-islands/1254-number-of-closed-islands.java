class Solution {
    private int rows, cols;
    private boolean dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return false;
        if (grid[r][c] == 1)
            return true;

        grid[r][c] = 1;
        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);
        return up && down && left && right;
    }
    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    if (dfs(grid, r, c))
                        count++;
                }
            }
        }

        return count;
    }
}