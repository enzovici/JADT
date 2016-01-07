package _ex;

import stack.Stack;

public class TestStack {

	public static void main(String[] args) {
		
		Stack<Integer>S= new QStackBis<Integer>();
		for(int i=1;i<10;i++)
			S.push(i);
		while(!S.isEmpty())
			System.out.print(S.pop()+" ");


	}

}
