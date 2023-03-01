package hot100;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // 这道题是递归
        // 也可以用迭代
        // 但是迭代的话，需要用到队列
        // 这里用递归
        return isSymmetric(root,root);
    }
    public boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }
}
