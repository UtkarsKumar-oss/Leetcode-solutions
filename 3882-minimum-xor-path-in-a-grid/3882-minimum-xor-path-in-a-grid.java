class Solution {
    public int minCost(int[][] grid) {
        int maxXOR = 1<<10;
        int[][][] dp  = new int[grid.length][grid[0].length][maxXOR];
        boolean[][][] visited  = new boolean[grid.length][grid[0].length][maxXOR];
        return helper(grid, 0, 0, 0, dp,visited);
    }
    int helper(int[][] grid, int r, int c , int temp, int[][][] dp,boolean[][][] visited){
        if(r>= grid.length || c>= grid[0].length){
            return Integer.MAX_VALUE;
        }
        temp ^= grid[r][c];
        if(r == grid.length-1 && c == grid[0].length - 1){
            return temp;
        }
        if(visited[r][c][temp]){
            return dp[r][c][temp];
        }
        visited[r][c][temp] = true;
        int right = helper(grid, r+1, c, temp, dp, visited);
        int left  = helper(grid, r, c+1, temp, dp, visited);
        return dp[r][c][temp] =  Math.min(right, left);
    }
}