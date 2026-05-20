package stackandqueue;

public class MyArrayStack{

	private int size;
	private int[] stack;
	private int top;
	
	public MyArrayStack(int size) {
		if(size <= 0) throw new IllegalArgumentException("Stack size must be greater than zero");
		this.size = size;
		this.stack = new int[size];
		top = -1;
	}
	
	public int pop() {
		if(top < 0 ) throw new IllegalArgumentException("Stack is nothing to pop");
		return stack[top--];
	}
	
	public void push(int value) {
		if(top >= size) throw new IllegalArgumentException("Stack is full not able to push");
		else
			stack[++top]=value;
	}
	
	public int top() {
		if(top < 0) throw new IllegalArgumentException("Stack is does not containt any value");
		return stack[top];
	}
	
	public boolean isEmpty() {
		if(top > -1) return false;
		return true;
	}
	
	public static void main(String[] args) {
		MyArrayStack stack1 = new MyArrayStack(4);
		stack1.push(1);
		System.out.println("Stack is Empty:"+stack1.isEmpty());
		stack1.push(2);
		System.out.println(stack1.top());
		System.out.println(stack1.pop());
		System.out.println("Stack is Empty:"+stack1.isEmpty());
		System.out.println(stack1.pop());
	}
}
