package offer;

/**
 * @author ssscorch
 * @data 剑指offer 重建二叉树 输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。假设输入的前序遍历和
 *       中序遍历的结果中都不含重复的数字。例如输 入前序遍历序列{1,2,4,7,3,5,6,8}和
 *       中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉 树并返回
 * 
 * 
 * 
 *  递归 前序遍历的第一个值是树的根节点，找到中序遍历中的这个数，将 中序划分为左右子树两个部分。
 *       
 *      节点 getRoot(前序，中序)

		c=前序第一个字符

		pos=c在中序中的位置

		len1=中序pos左半部分长度

		len2=中序pos右半部分长度

		新建节点r，令r的元素等于c

		r的左儿子=getRoot(前序位置1开始的len1长度部分，中序pos位置的左半部分)

		r的右儿子=getRoot(前序位置len1开始右半部分，中序pos位置的右半部分)

		return r
 * 
 */

public class RebuildBinaryTree{
	
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		int length = in.length;
		if (length == 0) {
			return null;
		}
		TreeNode temp = new TreeNode(pre[0]);
		int pos = 0;
		for (int i = 0; i <length; i++) {
			if(in[i] == pre[0]){
				pos = i;
				break;
			}
		}
		int len1 = pos;
		int len2 = length-pos-1;
		//根据root重建数组
		//分为前序遍历的左子树，右子树
		int[] preleft = new int[len1];
		for (int i = 0; i < len1; i++) {
			preleft[i] = pre[1+i];
		}
		int[] preright = new int[len2];
		for (int i = 0; i < len2; i++) {
			preright[i] = pre[len1+i+1];
		}
		
		//中序遍历的左子树，右子树
		int[] inleft = new int[len1];
		for (int i = 0; i < len1; i++) {
			inleft[i] = in[i];
		}
		int[] inright = new int[len2];
		for (int i = 0; i < len2; i++) {
			inright[i] = in[pos+i+1];
		}
		//用数组下标来划分，不另外占用内存空间
		
		//中序遍历左子树 [0,root-1] 右子树[root+1,length-1]
		
		TreeNode rNode = temp;
		if(len1>0){
		rNode.left = reConstructBinaryTree(preleft, inleft);
		}
		if(len2>0){
		rNode.right = reConstructBinaryTree(preright, inright);
		}
		return rNode;
	}
}


// 树节点
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}
}
