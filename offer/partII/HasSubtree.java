package offer.partII;

import treeNode.*;

/**
* @author WaldenLu
* @data   2017年4月22日上午11:01:15
* root2 是不是 root1的子结构
*/
public class HasSubtree {
	  public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		  boolean result = false;
		  if (root2 == null) {
			return false;
		  }
		  if(root1!=null&&root2!=null){
			  if (root1.val == root2.val) {
				result = doesTree1HasTree2(root1, root2);				  
			}
			  if (!result) {
				result = hasSubtree(root1.left, root2);
			}
			  if (!result) {
				result = hasSubtree(root1.right, root2);
			}
			  
		  }
		return result;
	    }
	  
	  private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
		  
		if (root2 == null) 
			return true;
		if (root1 == null) 
			return false;
		if (root1.val!=root2.val) {
			return false;
		}
		return doesTree1HasTree2(root1.left, root2.left)&&doesTree1HasTree2(root1.right, root2.right);
	}
}
