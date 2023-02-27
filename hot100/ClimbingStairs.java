package hot100;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // 动态规划
        // dp[i]是到第i阶的方法数目
        // dp[i] = dp[i-1]+dp[i-2];
        // 斐波那契数列
        if(n == 0) return 1;
        if(n == 1) return 1;
        int dp0 =1;
        int dp1 =1;
        int result = 0;
        for(int i=2;i<=n;i++){
            result = dp0+dp1;
            dp0=dp1;
            dp1 =result; 
        }
        return result;
    }
}
