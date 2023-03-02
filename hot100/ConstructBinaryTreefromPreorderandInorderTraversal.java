package hot100;

import java.util.Arrays;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(){
      // 这是一个递归
        // 每次重复以下步骤
        // 1.根据前序遍历找到根节点
        // 2.根据根节点和中序遍历找到左右子树
        // 对左右子树重复这一步骤
        // 难在对区间的判断                                                     
        int rootval = preorder[0];
        int length = preorder.length;
        int rootindex = findIndex(rootval,inorder);
        int leftLength = rootindex;
        int rightLength = length-1-rootindex;
        TreeNode root = new TreeNode(rootval);
        if(rootindex > 0){
            // 大于0说明左子树有值
            // 可以优化
            // 直接调用系统的copyArray方法
            root.left = buildTree(Arrays.copyOfRange(preorder,1,1+leftLength),Arrays.copyOfRange(inorder,0,rootindex));
        }else{
            root.left = null;
        }
        if(rootindex < inorder.length-1){
            root.right = buildTree(Arrays.copyOfRange(preorder,1+leftLength,length),Arrays.copyOfRange(inorder,rootindex+1,length));
        }else{
            root.right = null;
        }
        return root;
    }

    /**
     * 可以优化
     * 用二分查找
     * @param target
     * @param arr
     * @return
     */
    public int findIndex(int target,int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}
