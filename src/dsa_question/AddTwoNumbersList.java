package dsa_question;

class ListNode  {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbersList {
	
	// work for small numbers
	static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
		
		long num1 = 0;
		long num2 = 0;
		long increase = 1;
		while(list1 != null) {
			num1 += list1.val*increase;
			increase *=10;
			list1 = list1.next;
		}
		increase = 1;
		while(list2 != null) {
			num2 += list2.val*increase;
			increase *=10;
			list2 = list2.next;
		}
		long total = num1 + num2;
		
		ListNode result = new ListNode((int)(total%10));
		total /=10;
		ListNode dummy = result;
		while(total != 0) {
			ListNode newNode = new ListNode((int)(total%10));
			total /= 10;
			dummy.next = newNode;
			dummy = dummy.next;
		}
		
		return result;
	}
	
	static ListNode addTwoNumbersBig(ListNode l1, ListNode l2) {
		
		ListNode result = new ListNode(0), dummy = result;
        int total = 0, carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            total = carry;
            int a = (l1 != null)? l1.val : 0;
            int b = (l2 != null)? l2.val : 0;
            total = total+a+b;
            carry = total /10;
            dummy.next = new ListNode(total%10);
            dummy = dummy.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
		return result.next;
	}

	public static void main(String[] args) {
		
//		ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
//		ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		
		
		ListNode list1 = new ListNode(9);
		ListNode list2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
		
//		ListNode result = addTwoNumbers(list1, list2);
		ListNode result = addTwoNumbersBig(list1, list2);
		
		while(result != null) {
			System.out.print(result.val+" ");
			result = result.next;
		}
		
	}
}
