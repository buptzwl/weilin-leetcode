package hot100;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new  ArrayList<>();
        preorder(root,list);
        for(int i=1;i<list.size();i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
        
    }

    public void preorder(TreeNode root,List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preorder(root.left,list);
            preorder(root.right,list);
        }
    }
}
