package offer.partIV;

import java.util.ArrayList;

import treeNode.TreeNode;

/**
 * @author WaldenLu
 * @data 2017年4月27日下午9:02:44 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *       路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
	
	 public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
		 //DFS
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
		 
		 if (root == null) {
			return listAll;
		}
		 
		 
		 
		 
		return null;
	        
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
//	递归的解法
		/*	 ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
			 ArrayList<Integer> list = new ArrayList<Integer>();
			 ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
			        if(root == null) return listAll;
			        list.add(root.val);
			        target -= root.val;
			        if(target == 0 && root.left == null && root.right == null) 
			        	listAll.add(new ArrayList<Integer>(list));
			        findPath(root.left, target);
			        findPath(root.right, target);
			        list.remove(list.size()-1);
			        return listAll;
		}*/
}

