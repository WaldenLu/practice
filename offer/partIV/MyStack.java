package offer.partIV;

/**
 * @author WaldenLu
 * @data 2017年4月24日下午4:38:33 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MyStack {
	static final int MAX_ = 100;
	static int[] myStack = new int[MAX_];
	static int[] minStack = new int[MAX_];
	static int index = 0;

	public static void push(int node) {
		if (index == 0) {
			minStack[index] = node;
		} else if (node < minStack[index - 1]) {
			minStack[index] = node;
		} else {
			minStack[index] = minStack[index - 1];
		}
		myStack[index] = node;

		index++;
	}

	public static void pop() {
		index--;
	}

	public static int top() {

		return myStack[index-1];
	}

	public static int min() {
		return minStack[index-1];
	}
	
	public static void main(String[] args) {
		push(3);
		push(4);
		push(2);
		push(1);
		pop();
		pop();
		push(0);
		System.out.println(index);
		System.out.println(myStack[1]+" "+minStack[1]);
	}
	
}
