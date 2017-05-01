package offer;

import java.util.Stack;

/**
 * @author WaldenLu
 * @data 2017年4月18日下午11:11:15 两个栈实现一个队列
 */
public class Stack2queue {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		//向stack1中push
		stack1.push(node);
	}

	public int pop() {
		if(stack2.size()==0){
			//stack1->stack2
			if (stack1.size()==0) {
				return -1;
			}else{
				while(stack1.size()!=0){
					stack2.push(stack1.pop());
				}
			}
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		Stack2queue s2q = new Stack2queue();
		s2q.push(1);
		s2q.push(2);
		s2q.push(3);
		s2q.push(4);
		System.out.println(stack1);
		System.out.println(s2q.pop());
	}
}
