package stackandqueue.preInpostconversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Conversions {
	
	public static String convertInfixToPostFix(String str) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('^', 3);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if((ch >= 'A' && ch <='Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
				ans +=ch;
			else if(ch == '(') stack.push(ch);
			else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					ans +=stack.pop();
				}
				stack.pop();
			}
			else {
				while(!stack.isEmpty() && (priority.get(stack.peek()) > priority.get(ch) ||
						(priority.get(stack.peek()) == priority.get(ch) && ch != '^'))) {
					ans += stack.pop();
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		
		return ans;
	}
	
	public static String convertInfixToPrefix(String str) {
		str = reverseString(str);
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('^', 3);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		String ans = "";
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <='9'))
				ans += ch;
			else if(ch == '(') stack.push(ch);
			else if(ch == ')') {
				while(stack.peek() != '(')
					ans +=stack.pop();
				stack.pop();
			}
			else {
				if(!stack.isEmpty() && stack.peek() == '^') {
					while(!stack.isEmpty() && (priority.get(stack.peek()) >= priority.get(ch))) {
						ans += stack.pop();
					}
				}
				else {
					while(!stack.isEmpty() && priority.get(stack.peek()) > priority.get(ch)) {
						ans += stack.pop();
					}
				}
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty()) {
			ans += stack.pop();
		}
		
		return reverseString(ans);
	}
	
	private static String reverseString(String str) {
		String reverse = "";
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(str.length()-i-1);
			if(ch == '(') reverse += ')';
			else if(ch == ')') reverse += '(';
			else
				reverse += ch;
		}
		
		return reverse;
	}
	
	public static void main(String[] args) {
		
		String infix = "A^B^C";//"(A+B)*(C-D)/E^F"; //"A+(B*C-D)/(E+F*G)";
		System.out.println(convertInfixToPostFix(infix));
		
		System.out.println(convertInfixToPrefix(infix));
	}
}
