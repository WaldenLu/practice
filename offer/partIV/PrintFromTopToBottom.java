package offer.partIV;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


import treeNode.TreeNode;

/**
* @author WaldenLu
* @data   2017年4月26日下午9:38:51
* 二叉树的层次遍历
*/
public class PrintFromTopToBottom {
	 public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 ArrayList<Integer> solution = new ArrayList<Integer>();
		 if (root == null) {
			 return solution;
		}
		 
		 TreeNode ouTreeNode = null;
		 queue.offer(root);
		 while(!queue.isEmpty()){
			 solution.add(queue.peek().val);
			 ouTreeNode = queue.poll();
			 if (ouTreeNode.left!=null) {
				queue.offer(ouTreeNode.left);
			}
			 if (ouTreeNode.right!=null) {
				queue.add(ouTreeNode.right);
			}
		 }
		 
		return solution;
	    }
}
