package hot100;
/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n){
        // 1. 定义状态
        // dp[i]表示i个节点的二叉搜索树的个数
        int[] dp = new int[n+1];
        // 2. 初始化
        dp[0] = 1;
        dp[1] = 1;
        // 3. 状态转移
        // dp[i] = dp[0]*dp[i-1] + dp[1]*dp[i-2] + ... + dp[i-1]*dp[0]
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
