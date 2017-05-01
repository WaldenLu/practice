package offer.partII;

/**
 * @author WaldenLu
 * @data 2017年4月19日下午3:22:36 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
	public static int numberOf1(int n) {
		
		/*
		 * 这种解法负数会死循环
		 * 因为负数右移会在高位补1
		 * int count = 0;
		while(n != 0){
			if ((n&1) == 1) {
				count++;
			}
			n = n>>1;
		}
		return count;
		*/
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if ((n&flag) != 0) {
				count++;
			}
			flag = flag<<1;
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		int n =NumberOf1.numberOf1(3);
		System.out.println(n);
	}
}
