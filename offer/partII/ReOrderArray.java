package offer.partII;

/**
 * @author WaldenLu
 * @data 2017年4月19日下午5:38:36 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *       使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分， 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
	public static void reOrderArray(int[] array) {
		int len = array.length;
		int[] evenArray = new int[len];
		
		int j = 0;
		int n =0;
		for (int i=0; i < len; i++) {
			if (array[i]%2==0) {
				evenArray[j++] = array[i];
			}else{
				array[n++] = array[i];
			}
		}
		
		for (int i = 0; i < j; i++) {
			array[n++] = evenArray[i];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {};
		reOrderArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}
