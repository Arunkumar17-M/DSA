package dsa_question;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParathesis {

	public boolean validParathesis(String str) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else {
				if(stack.isEmpty()) return false;
				char temp = stack.pop();
				if(temp != map.get(ch)) return false;
			}
			
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		BalancedParathesis bp = new BalancedParathesis();
		System.out.println(bp.validParathesis("]"));
	}
}
