package hot100;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }

        return res;

    }
    
}
