package stackandqueue;

public class QueueArray {

	private int capacity;
	private int[] queueArr;
	private int currentSize;
	private int start;
	private int end;
	
	public QueueArray(int size) {
		capacity = size;
		queueArr = new int[size];
		currentSize = 0;
		start = -1;
		end = -1;
	}
	
	public void push(int value) {
		if(currentSize == capacity) throw new IllegalArgumentException("Queue is full not able to push the value");
		if(currentSize == 0) {
			start = 0;
		}
		end = (end+1)%capacity;
		queueArr[end] = value;
		currentSize++;
	}
	
	public int pop() {
		if(currentSize == 0) throw new IllegalStateException("Queue is empty not able to pop the element");		
		int temp = queueArr[start];
		if(currentSize == 1) {
			start = -1;
			end = -1;
		}
		else {			
			start = (start+1)%capacity;
		}
		currentSize--;		
		return temp;
	}
	
	public int top() {
		if(currentSize == 0) throw new IllegalStateException("Queue is not having any value");
		return queueArr[start];
	}
	
	public static void main(String[] args) {
		QueueArray queue = new QueueArray(4);
		queue.push(4);
		queue.push(5);
		System.out.println(queue.top());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.pop();
	}
}
