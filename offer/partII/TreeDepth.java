package offer.partII;

import treeNode.*;
/**
* @author WaldenLu
* @data   2017年4月23日下午8:29:14
* 树的深度
*/

  

public class TreeDepth {
    public int treeDepth(TreeNode root) {
    	
        if(root == null){
            return 0;
        }else if(root.left!=null||root.right!=null){
        	TreeNode left = root.left;
            TreeNode right = root.right;
            return 1 + ((treeDepth(left)>treeDepth(right))?treeDepth(left):treeDepth(right));
        }
		return 1;
        
    }
    
    
    public static void main(String[] args) {
		treeNode.TreeNode root = Tree.buildTree();
		int solu = new TreeDepth().treeDepth(root);
		System.out.println(solu);
	}
}