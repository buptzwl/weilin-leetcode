package hot100;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // 这题明显是个回溯
        // 独立做出 太爽了
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return result;
        }
        //
        List<Integer> ints = new ArrayList<Integer>();
        int index = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        dfs(result,nums,ints,index,set);
        return result;
    }

    public void dfs(List<List<Integer>> result,int[] nums,List<Integer> ints,int index,Set<Integer> set){
        if(index == nums.length){
            result.add(new ArrayList(ints));
            return;
        }else{
            for(int i=0;i<nums.length;i++){
                if(!set.contains(nums[i])){

                    ints.add(nums[i]);
                    set.add(nums[i]);
                    dfs(result,nums,ints,index+1,set);
                    ints.remove(index);
                    set.remove(nums[i]);
                }
            }       
        }

    }
}
