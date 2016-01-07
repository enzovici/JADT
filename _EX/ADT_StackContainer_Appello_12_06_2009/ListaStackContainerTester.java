package ADT_StackContainer_Appello_12_06_2009;

import position.NodePositionList;
import position.PositionList;
import stack.ArrayStack;
import stack.Stack;

public class ListaStackContainerTester {

	public static void main(String[] args) {

		ListStackContainer lista = new ListStackContainer();
		
		PositionList<Integer> p1 = new NodePositionList<Integer>();
		
		p1.addLast(1);
		p1.addLast(2);
		p1.addLast(3);
		p1.addLast(4);
		p1.addLast(5);
		p1.addLast(6);
		
	
		PositionList<Integer> p2 = new NodePositionList<Integer>();
		
		p2.addLast(111);
		p2.addLast(12);
		p2.addLast(13);
		p2.addLast(14);
		p2.addLast(15);
		p2.addLast(16);
		
	
		
		Stack<Integer> s1 = new ArrayStack<Integer>();
		lista.insert(s1,59);
		lista.insert(s1,49);
		lista.insert(s1,29);
		lista.insert(s1,19);
		
		
		lista.insert(p1);
		lista.insert(p2);
		
		
		Stack<Integer> b = new ArrayStack<Integer>();
		lista.insert(b,0);
		
		
		ArrayStack<Integer> c = (ArrayStack<Integer>) lista.remove();
		
		
		while(!c.isEmpty())
			System.out.print(c.pop()+" ");
		
		System.out.println("\n");
		while(!b.isEmpty())
			System.out.print(b.pop()+" ");
		
		System.out.println("\n");
		while(!s1.isEmpty())
			System.out.print(s1.pop()+" ");
		
	
	}

}
