package offer.partIV;

/**
 * @author WaldenLu
 * @data 2017年4月26日下午10:01:57 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *       如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
	public static boolean verifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0) {
			return false;
		}
		if(sequence.length == 1){
			return true;
		}
		int root = sequence[sequence.length - 1];
		int index = -1;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i]>root) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			index = sequence.length - 1;
		}
		int[] pre = new int[index];
		int[] post = new int[sequence.length-index-1];
		System.arraycopy(sequence, 0, pre, 0, index);
		System.arraycopy(sequence, index+1, post, 0, sequence.length-index-1);
		boolean flag = true;
		for (int i = 0; i < pre.length; i++) {
			if (root<pre[i]) {
				flag = false;
				return false;
			}
		}
		for (int i = 0; i < post.length; i++) {
			if (root>post[i]) {
				flag = false;
				return false;
			}
		}
		
		verifySquenceOfBST(pre);
		verifySquenceOfBST(post);
		
		return flag;

	}
	
	public static void main(String[] args) {
//		[4,8,6,12,16,14,10]
//		int[] sequence = {4,8,6,12,16,14,10};
//		1,2,3,4,5
//		int[] sequence = {1,2,3,4,5};
//		5,4,3,2,1
//		int[] sequence = {5,4,3,2,1};
//		7465
		int[] sequence = {7,4,6,5};
		boolean solu = verifySquenceOfBST(sequence);
		System.out.println(solu);
	}
}
