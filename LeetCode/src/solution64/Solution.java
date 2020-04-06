package solution64;

public class Solution {
    public int minPathSum(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for(int i = rowLength - 1; i >= 0; i--) {
            for(int j = colLength - 1; j >= 0; j--) {
                if(i == rowLength - 1 && j == colLength - 1)
                    dp[i][j] = grid[i][j];
                else if(i == rowLength - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if(j == colLength - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }
}
