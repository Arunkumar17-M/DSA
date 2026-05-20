package stackandqueue;

public class QueueLL {

	Node start;
	Node end;
	
	public QueueLL() {}
	
	public QueueLL(int value) {
		this.push(value);
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		if(end == null) {
			start = newNode;
			end = newNode;
		}
		else {
			end.next = newNode;
			end = newNode;
		}
	}
	
	public int pop() {
		if(start == null) throw new IllegalStateException("there is no element in the queue");
		int temp = start.value;
		start = start.next;
		if(start == null) {
			end = null;
		}
		
		return temp;
	}
	
	public int top() {
		if(start == null) throw new IllegalStateException("Queue is Empty");
		return start.value;
	}
	
	public boolean isEmpty() {
		if(start == null) return true;
		return false;
	}
	
	public static void main(String[] args) {
		QueueLL queue = new QueueLL();
		System.out.println(queue.isEmpty());
		queue.push(1);
		queue.push(2);
		System.out.println(queue.pop());
		System.out.println(queue.isEmpty());
		System.out.println(queue.pop());
	}
}
