package _ex;

import stack.*;

public class eserciziotore {
	public static void main(String args[]){
		Stack<Character> ar = new ArrayStack<Character>();
		String str = new String("a+(b*(c+d)-(e+f)*g)-h");
	
		for(int i=0;i<str.length();i++)
			ar.push(str.charAt(i));
			

		Stack <Character> t = new ArrayStack<Character>();
		char c=ar.top();
		while(!ar.isEmpty()){
			c=ar.pop();
			if(c=='(')
				t.push(c);
			else if(c==')')
				t.pop();
		}
		if(!t.isEmpty())
			System.out.println("le parentesi non sono accoppiate");
		else
			System.out.println("le parentesi sono accoppiate");
		}
		
	}
	

