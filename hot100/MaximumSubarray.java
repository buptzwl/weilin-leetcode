package hot100;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //我一看这题就觉得是滑动窗口
        // 还是动态规划？
        // 先按照滑动窗口来 左减右加 最初左右相等
        // ??? 为什么不是滑动窗口
        // 按照动态规划来做
        // dp[i]是以nums[i]结尾的最大值
        // 可以有转移方程
        // dp[i] = dp[i-1]+nums[i]
        int[] dp = new int[nums.length];
        // 初始化
        dp[0]=nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);// 因为dp[i]是以i结尾的，所以必须有nums[i]
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}