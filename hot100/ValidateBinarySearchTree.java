package hot100;

public class ValidateBinarySearchTree {
    // 这题一看就是递归
    // 还有一种中序遍历的解法
    // 下次挑战一下
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long min,long max){
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
