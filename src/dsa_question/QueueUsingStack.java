package dsa_question;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> s1;
	Stack<Integer> s2;
	
	public QueueUsingStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	public void push(int x) {
		s1.push(x);
	}
	
	public int top() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.peek();
	}
	
	public int pop() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}
	
	public static void main(String[] args) {
		QueueUsingStack queue = new QueueUsingStack();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println(queue.pop());
		queue.push(5);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
		System.out.println(queue.pop());
	}
}
