package hot100;

public class JumpGame {
    public boolean canJump(int[] nums) {
        // 记得这道题是从后往前
        int last = nums.length-1;
        for(int i = last;i>=0;i--){
            if(i+nums[i]>=last){
                last = i;
            }
        }
        return last == 0;
    }
}
