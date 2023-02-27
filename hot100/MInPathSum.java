package hot100;

public class MInPathSum {
    public int minPathSum(int[][] grid) {
        // 动态规划
        // dp[i][j] 是以 grid[i][j]为终点的最短和
        // dp[i][j] = Math(dp[i-1][j],dp[i][j-1])+grid[i][j]
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        // 初始化
        int sum =0;
        for(int i=0;i<rows;i++){
            sum+=grid[i][0];
            dp[i][0] =sum;  
        }
        sum = 0;
        for(int i=0;i<cols;i++){
            sum+=grid[0][i];
            dp[0][i] =sum;  
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                min = Math.min(min,dp[i][j]);
            }
        }
        return dp[rows-1][cols-1];
    }
    
}
