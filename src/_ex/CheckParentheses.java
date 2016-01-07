package _ex;

import stack.ArrayStack;
import stack.Stack;

public class CheckParentheses{
	
	public static boolean checkParentheses(String s){
		
		Stack<Character> S= new ArrayStack<Character>();
		
		for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='(') 
					S.push(s.charAt(i));
				if(s.charAt(i)==')')
					if(S.isEmpty()) return false;
				S.pop();
		}		
		if(S.isEmpty()) return true;
		return false;
	}

}
