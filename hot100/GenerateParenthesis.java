package hot100;

import java.util.Stack;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n){
        if (n == 0) {
            return new ArrayList<>();
        }
        if(n == 1) {
            return new ArrayList<>(Arrays.asList("()"));
        }
        List<String> result = new ArrayList<>();
        // 用回溯还是递归？
        // 递归的话，每次都是从头开始，所以要用一个变量记录当前的位置
        int index = 0;
        digui(result, n, index, "");
    }
    public void digui(List<String> result,int n,int index,String str){
        if(index ==2*n){
            if(isValid(str)){
                result.add(str);
            }
        }else{
            digui(result, n, index+1, str+"(");
            digui(result, n, index+1, str+")");
        }
    }
    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
