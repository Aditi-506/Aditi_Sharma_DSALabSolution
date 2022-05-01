/**
 * 
 */
package com.greatlearning.lab3;

import java.util.Stack;

/**
 * @author Admin
 *
 */
public class BalancedBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "( [ [ { } ] ] )";
		if (checkBalance(inputString)) {
			System.out.println("\nThe entered string has Balanced Bracket.");
		}
		else {
			System.out.println("\nThe entered string do not contain Balanced Bracket.");
		}

	}

	static boolean checkBalance(String bracketexpression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < bracketexpression.length(); i++) {
			char a = bracketexpression.charAt(i);
			if (a == '(' || a == '[' || a == '{') {
				stack.push(a);
				continue;

			}
			if (stack.isEmpty()) {
				return false;

			}
			char c;
			switch (a) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[') {
					return false;

				}
				break;
			case ')':
				c = stack.pop();
				if (c == '{' || c == '[') {
					return false;
				}
				break;

			case ']':
				c = stack.pop();
				if (c == '(' || c == '{') {
					return false;

				}
				break;

			default:
				break;
			}
		}

		return stack.isEmpty();

	}
}
