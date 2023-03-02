package hot100;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        // 第一个想到的是动态规划
        // 第二个想到的是双指针的滑动窗口
        // 最简单的就是暴力解法
        // 1.暴力解法
        // 暴力解法直接超时
        int length = prices.length;
        int max = 0;
        // for(int i =0;i<length;i++){
        //     for(int j =i+1;j<length;j++){
        //         if(prices[j]>prices[i]){
        //             max = Math.max(max,prices[j] - prices[i]);
        //         }
        //     }
        // }
        // 2.动态规划
        // dp[i] = 第i天的最大利润
        // 初始化
        // dp[0] = 0
        // 转移方程,转移方程错了
        // dp[i] = dp[i-1]+Math.max(0,prices[i]-prices[i-1])
        // 这题用不了动态规划
        // int[] dp = new int[length];
        // dp[0] = 0;
        // for(int i =1;i<length;i++){
        //     dp[i] = dp[i-1]+Math.max(0,prices[i]-prices[i-1]);
        //     max = Math.max(max,dp[i]);
        // }
        // return max;
        int minprice = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }else{
                max = Math.max(max,prices[i] - minprice);
            }
        }
        return max;


    }
}
