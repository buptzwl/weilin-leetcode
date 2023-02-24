package hot100;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
         // 我以为这题用回溯
        // 实际上这种认清模式然后分类的用的是hashtable
        // 排序后的字段做key 未排序的做value
        // 最后遍历输出就好
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            // 排序的这步利用数组
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}
