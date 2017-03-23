package offer;
/**
* @author ssscorch
* @data   
* 剑指offer 从尾到头打印链表
* 使用栈
*/

import java.util.ArrayList;

public class ArraryListSolution {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {	
		if (listNode == null) {
			ArrayList<Integer> arrayList = new ArrayList<>();
			System.out.println(arrayList);
			return arrayList;
		}
		final int MAXSIZE = 1000;
		//存放返回值的arraylist 内存储Interge
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		int[] temp = new int[MAXSIZE];
		int i = 0;
		while (listNode.next != null ) {
			temp[i] = listNode.val;
			++i;
			listNode = listNode.next;
		}
		//处理最后一个节点
		temp[i] = listNode.val;
		
		for (int j = i; j >=0 ; j--) {
			arrayList.add(Integer.valueOf(temp[j]));
		}
		
		return arrayList;
	}
}
class Test{
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		node1 = null;
		
		ArraryListSolution solution = new ArraryListSolution();
		ArrayList<Integer> arrsolution = solution.printListFromTailToHead(node1);
		System.out.println(arrsolution);
	}
}


//节点数据结构
class ListNode{
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
	
}