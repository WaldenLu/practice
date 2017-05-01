package offer.partIV;

import java.util.Stack;

/**
* @author WaldenLu
* @data   2017年4月24日下午5:10:21
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
*/
public class IsPopOrder {
	 public boolean isPopOrder(int [] pushA,int [] popA) {
	      Stack<Integer> stack = new Stack<Integer>();
	      int popindex = 0;
	      if (pushA.length == 0 || popA.length == 0) {
			return false;
		}
	      for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while(!stack.empty()&&popA[popindex]==stack.peek()) {
				stack.pop();
				popindex++;
			}
			
		}
	      return stack.isEmpty();
	    }
}
