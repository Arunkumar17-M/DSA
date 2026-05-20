package stackandqueue;

public class StackUsingLinkedList {
	
	Node head;
	
	public StackUsingLinkedList() {}
	
	public StackUsingLinkedList(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
	}
	
	public void push(int value) {
		if(head == null)
			head = new Node(value);
		else {
			Node newNode = new Node(value);
			newNode.next = head;
			head = newNode;
		}
	}
	
	public int pop() {
		if(head == null) throw new IllegalStateException("Stack does not contain any value");
		int temp = head.value;
		head = head.next;
		return temp;
	}
	
	public int top() {
		if(head == null) throw new IllegalStateException("Stack is Empty");
		return head.value;
	}
	
	public boolean isEmpty() {
		if(head == null) return true;
		return false;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
	}
}
