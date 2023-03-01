package hot100;

public class MaxDepth {
    public int MaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        // +1 是因为要算上根节点
        return Math.max(MaxDepth(root.left),MaxDepth(root.right))+1;
    }
}
