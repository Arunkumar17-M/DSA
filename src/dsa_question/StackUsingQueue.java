package dsa_question;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1;
	Queue<Integer> q2;
	
	public StackUsingQueue() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	public void pushApporch1(int x) {
		q1.add(x);
		for(int i = 0; i < q1.size()-1; i++) {
			q1.add(q1.poll());
		}
	}
	
	public void pushApporch2(int x) {
		q2.add(x);
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public int pop() {
		return q1.poll();
	}
	
	public int top() {
		return q1.peek();
	}
	
	public boolean empty() {
		return q1.isEmpty();
	}
	
	public static void main(String[] args) {
		StackUsingQueue sq = new StackUsingQueue();
		sq.pushApporch1(2);
		sq.pushApporch1(3);
		System.out.println(sq.top());
		System.out.println(sq.pop());
		System.out.println(sq.top());
		System.out.println(sq.empty());
	}
}
