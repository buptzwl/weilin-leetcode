package hot100;

public class NextPermutation {
    public void nestPermutation(int[] nums) {
        int len = nums.length;
        int i = len-1;
        while(i>0&&nums[i-1]>=nums[i]){
            i--;
        }
        if(i==0){
            reverse(nums,i,len-1);
        }else{
            i = i-1;
            int j = len -1;
            while(j>i&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
            reverse(nums,i+1,len-1);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
          int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
    
        }
    }
}
