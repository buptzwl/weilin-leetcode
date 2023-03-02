package hot100;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 这道题十分的有意思，因为是要求用o(n)的时间复杂度
        // 所以用到了哈希表，将是否有下一个在数组信息存储在哈希表中
        // 准确说是一个hashset，去重
        if(nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longestConsecutive = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curConsecutive = 1;
                while(set.contains(num+1)){
                    curConsecutive++;
                    num++;
                }
                longestConsecutive = Math.max(longestConsecutive,curConsecutive);
            }
        }
        return longestConsecutive;

    }
}
