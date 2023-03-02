package hot100;

public class SingleNumber {
    public int singleNumber(int[] nums){
        // 其实就是很简单的位运算
        // 主要还是考察思路
        int res = 0;
        for(int i:nums){
            res^=i;
        }
        return res;

    }
}
