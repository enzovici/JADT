package ADT_StackContainer_Appello_12_06_2009;

import position.PositionList;
import priorityQueue.PriorityQueue;
import priorityQueue.SortedListPriorityQueue;
import stack.ArrayStack;
import stack.Stack;

public class ListStackContainer implements StackContainer {

	private SumStackComparator<Integer> comp;
	private PriorityQueue<Integer,Stack<Integer>> listaStack; 
	
	
	public ListStackContainer(){
		comp = new SumStackComparator<Integer>();
		listaStack = new SortedListPriorityQueue<Integer, Stack<Integer>>(comp);
	}
	
	
	public Stack<Integer> insert(Stack<Integer> S, Integer e) {
		
		S.push(e);
		Stack<Integer> stack = S;
		listaStack.insert(stack.top(),stack);
	
		return stack;
	}


	public Stack<Integer> insert(PositionList<Integer> L) {
		int somma=0;
		Stack<Integer> stack = new ArrayStack<Integer>();
		for(Integer x : L){
			stack.push(x);
			somma+=x;
		}
		listaStack.insert(somma,stack);
	
		return stack;
	}

	
	public Stack<Integer> remove() {
		
		return listaStack.removeMin().getValue();
	}

}
