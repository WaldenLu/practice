package offer.partII;
/**
* @author WaldenLu
* @data   2017年4月20日下午5:37:09
* 反转链表
* 
*/
public class ReverseList {
	
public ListNode reverseList(ListNode head) {
	ListNode pre = null;
	ListNode current = head;
	ListNode temp = null;
	
	while(current!=null){
		temp = current.next;
		current.next = pre;
		pre = current;
		
		current = temp;
		
	}
	return pre;
    }


public static void main(String[] args) {
	ListNode listNode1 = new ListNode(1);
	ListNode listNode2 = new ListNode(2);
	ListNode listNode3 = new ListNode(3);
	ListNode listNode4 = new ListNode(4);
	
	ListNode head = listNode1;
	listNode1.next = listNode2;
	listNode2.next = listNode3;
	listNode3.next = listNode4;
	
	new ReverseList().reverseList(head);
	
	System.out.println(listNode4.next.val);
	
	
}
}
