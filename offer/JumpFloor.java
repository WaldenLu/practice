package offer;
/**
* @author WaldenLu
* @data   2017年4月19日上午10:30:50
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/

/*
 * 思路：当只有一级台阶的时候，青蛙的跳法也只有一种。当有两级台阶的时候，
 * 青蛙的跳法有两种（一是：一下跳两级台阶，二是：一级一级的跳）。
 * 当有n级台阶的时候，青蛙在第一次起跳的时候只跳了一级台阶，
 * 则还剩下n-1级台阶的跳法，如果在第一次起跳的时候跳了两级台阶，
 * 则还剩下n-2级台阶的跳法。整个题目正好是一个斐波拉契数列。
 */
public class JumpFloor {
	 public static int jumpFloor(int target) {
		 int a,b,c = 0;
			if (target == 0) {
				return 0;
			}else if(target == 1){
				return 1;
			}else if(target == 2){
				 return 2;
			}else{
				a = 1;
				b = 2;
				for(int i = 3;i<=target;++i){
					c = a + b;
					a = b;
					b = c;
				}
				return c;
			}
	    }
	 
	 public static void main(String[] args) {
		System.out.println(JumpFloor.jumpFloor(2));
	}
}
