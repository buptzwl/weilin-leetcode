package hot100;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums,int target){
        if(nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        int start = left;
        left = 0;
        right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;  
            if(nums[mid]<=target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        int end = right;
        if(start<=end){
            return new int[]{start,end};
        }else{
            return new int[]{-1,-1};
        }
    }
}
