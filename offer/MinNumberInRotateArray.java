package offer;

/**
 * @author WaldenLu
 * @data 2017年4月18日下午11:45:22 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *       输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *       例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *       NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

	public static int minNumberInRotateArray(int[] array) {
		int length = array.length;
		int result = 0;
		if (length == 0) {
			return 0;
		} else {
			for (int i = 1; i < length; i++) {
				if (array[i-1] > array[i]) {
					result = array[i];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,5,1,2};
		int solu = MinNumberInRotateArray.minNumberInRotateArray(array);
		System.out.println(solu);
	}
}
