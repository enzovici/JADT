package ADT_StackContainer;

import stack.Stack;

public class TestStackContainer {

	public static void main(String[] args) {
		
		StackContainer<Integer> listStack = new ListStackContainer<Integer>();
		
		
		if(listStack.isEmpty())
			System.out.println("Il container è vuoto");
		else 
			System.out.println("Il container non è vuoto");
		
		listStack.insert(0);
		Stack<Integer> stack2 = listStack.insert(10);
		Stack<Integer> stack3 = listStack.insert(2);
		
		System.out.println("La taglia è: "+listStack.size());
		System.out.println("Faccio il pop su 'stack2': "+listStack.pop(stack2));	
		
		System.out.println("Inserisco quattro elementi nello stack 3");
		listStack.push(stack3, 1);
		listStack.push(stack3, 2);
		listStack.push(stack3, 3);
		listStack.push(stack3, 4);
		System.out.println("Faccio il pop su 'stack3': "+listStack.pop(stack3));
		
		System.out.println("Rimuovo uno stack!");
		listStack.remove(stack3);
		
		System.out.println("La taglia è: "+listStack.size());
		
				
	}
	
}
