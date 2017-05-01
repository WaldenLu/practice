package offer.partII;
/**
* @author WaldenLu
* @data   2017年4月20日下午1:57:04
* 链表倒数第k个节点
*/
public class FindKthToTail {
	public static ListNode findKthToTail(ListNode head,int k) {
        ListNode p = head;
        ListNode q = new ListNode(0);
        q.next = head;
        int count = 0;
        if (head == null) {
			return null;
		} else {
		       while(p!=null){
		            count++;
		            p = p.next;
		        }
				System.out.println("count:"+count);
		        if(count<k){
//		        	System.err.println("count<k");
		            return null;
		        }else{
		            //正数第 count-k+1
		            
		            while(count-k+1>0){
		                q = q.next;
		                count--;
		            }
		            
		        }
		        return q;

		}
 
    }
	
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		
		ListNode solu = findKthToTail(listNode1, 5);
		System.out.println(solu.val);
		
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}