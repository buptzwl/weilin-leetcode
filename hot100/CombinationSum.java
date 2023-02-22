package hot100;

import java.util.Collections;
import java.util.List;

public class CombinationSum {
    // 回溯就是 dfs
    // 1. 递归的终止条件
    // 2. 递归的过程
    // 3. 递归的返回值
    // 4. 递归的参数
    // 5. 递归的剪枝
    // 6. 递归的重复计算
    // 7. 递归的重复计算的优化
    // 这部分要好好看看
   
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int sum = 0;
        int index=0;
        List<Integer> arr = new ArrayList<>();
        dfs(candidates,result,index,sum,arr,target);
        return result;
    }
    
    public void dfs(int[] candidates,List<List<Integer>> result,int index,int sum,List<Integer> arr,int target){
        // 进入dfs 立刻判断是否满足条件
        if(sum==target){
            List<Integer> temp = new ArrayList<>(arr);
            Collections.sort(temp);
            if(!result.contains(temp)){
                result.add(temp);
            }
            return;
        }else if(sum>target){
            return;
        }else{
            for(int i=index;i<candidates.length;i++){
                arr.add(candidates[i]);
                dfs(candidates,result,i,sum+candidates[i],arr,target);
                arr.remove(arr.size()-1);
            }
        }
    }
    
}
