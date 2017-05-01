package offer.partII;

/**
* @author WaldenLu
* @data   2017年4月20日下午7:42:57
* 两个升序链表合成一个不降序链表
* 
*/
public class ErrMerge {
public ListNode merge(ListNode list1,ListNode list2) {
		ListNode pre = list1;
		ListNode head1 = list1;
		ListNode head2 = list2;
		
		while (list1.next!=null||list2.next!=null) {
			if (list1.val <= list2.val) {
				while (list1.val < list2.val) {
					pre = list1;
					list1 = list1.next;
				}
				pre.next = list2;
				list2 = head1;
				
			} else {
				while(list1.val > list2.val){
					pre = list2;
					list2 = list2.next;
				}
				pre.next = list1;
				list1 = head2;
			}	
		}
		
		return list2.next==null?list1:list2;
    }

public static void main(String[] args) {
	ListNode listNode1 = new ListNode(1);
	ListNode listNode2 = new ListNode(3);
	ListNode listNode3 = new ListNode(5);
	ListNode listNode4 = new ListNode(9);
	
	listNode1.next = listNode2;
	listNode2.next = listNode3;
	listNode3.next = listNode4;
	
	ListNode listNode11 = new ListNode(2);
	ListNode listNode22 = new ListNode(4);
	ListNode listNode33 = new ListNode(5);
	ListNode listNode44 = new ListNode(6);
	
	listNode11.next = listNode22;
	listNode22.next = listNode33;
	listNode33.next = listNode44;
	
	ListNode list1 = listNode1;
	ListNode list2 = listNode11;
	
	System.out.println(list1.next == null);
	ListNode newnode = new ErrMerge().merge(list1, list2);
	while(newnode!=null){
		System.out.print(newnode.val+ "\t");
		newnode = newnode.next;
	}
	
}
}
