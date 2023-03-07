package hot100;

public class HouseRobber {
    public int rob(int[] nums) {
        // 太经典这道题
        // 对于当前的节点分偷还是不偷两种状态
        // 这种题其实还是很多的
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        if(length == 1){
            return nums[0];
        }
        if(length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp =new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[length-1];
    }
}
