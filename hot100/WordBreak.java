package hot100;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordBreak {
    public boolean WordBreak(String s,List<String> wordDict){
        Set<String> wordSet = wordDict.stream().collect(Collectors.toSet());
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i =1;i<=length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
