package hot100;

public class SubSet {
    
    public List<List<Integer>> subsets(int[] nums) {
        // 我感觉是回溯
        // 不重复是要用set吗？
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int index = 0;
        List<Integer> list = new ArrayList<>();
        dfs(index,nums,list,result);
        return result;
    }
    public void dfs(int index,int[] nums,List<Integer> list,List<List<Integer>> result){
        // 递归终止条件
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        // 递归过程
        // 不选
        dfs(index+1,nums,list,result);
        // 选
        list.add(nums[index]);
        dfs(index+1,nums,list,result);
        // 回溯
        list.remove(list.size()-1);// 添加进去的必须回溯，删掉的就是最后一位
    }

}
