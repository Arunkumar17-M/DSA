package stackandqueue;

public class StackUsingGeneric<T> {

	private int capacity;
	private Object[] stackArray;
	private int top;
	
	public StackUsingGeneric(int size){
		if(size <= 0) throw new IllegalArgumentException("Stack size should be more than zero");
		capacity = size;
		stackArray = new Object[size];
		top = -1;
	}
	
	public Object pop() {
		if(top < 0) System.out.println("Data is not available please push some data");
		else 
			return stackArray[top--];
		return new Object();
	}
	
	public void push(T value) {
		if(top+1 >= capacity) System.out.println("Capacity is full not able to push the data");
		else {
			stackArray[++top] = value;
		}
	}
	
	public Object top() {
		if(top < 0 ) System.out.println("Stack does not contain value");
		else
			return stackArray[top];
		
		return new Object();
	}
	
	public boolean isEmpty() {
		if(top > -1) return false;
		return true;
	}
	
	public static void main(String[] args) {
		StackUsingGeneric<Integer> stack = new StackUsingGeneric<>(2);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack.top());
	}
}

