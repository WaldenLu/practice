package offer.partII;

/**
 * @author WaldenLu
 * @data 2017年4月20日下午9:09:43
 * 
 */
public class Merge {
	public ListNode merge(ListNode list1, ListNode list2){
	/*	
		if(list1.next == null){
			return list2;
		}
		if (list2.next == null) {
			return list1;
		}
		if (list1.val<=list2.val) {
			list1.next = merge(list1.next, list2);
			return list1;
		}else {
			list2.next = merge(list1, list2.next);
			return list2;
		}*/
	
			if(list1 == null){
			    return list2;
			    }
			    if(list2 == null){
			    return list1;
			    }
			    ListNode mergeHead = null;
			    ListNode current = null;  
			    while(list1!=null && list2!=null){
			    if(list1.val <= list2.val){
			    if(mergeHead == null){
			       mergeHead = current = list1;
			    }else{
			       current.next = list1;
			       current = current.next;
			    }
			    list1 = list1.next;
			    }else{
			    if(mergeHead == null){
			       mergeHead = current = list2;
			    }else{
			       current.next = list2;
			       current = current.next;
			    }
			    list2 = list2.next;
			    }
			    }
			    if(list1 == null){
			    current.next = list2;
			    }else{
			    current.next = list1;
			    }
			    return mergeHead;
	}
}
