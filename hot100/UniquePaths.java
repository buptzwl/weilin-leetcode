package hot100;

public class UniquePaths {
    public int uniquePaths(int m,int n){
        // 这道题是从左上角到右下角
        // 动态规划
        // dp[i][j] 表示的是到达i,j的路径数
        // 则转移方程为 dp[i][j] = d[i-1][j]+dp[i][j-1]
        // 初始化
        // 这步真的非常重要，因为是从左上角到右下角，所以第一行和第一列都是1
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    
}
