package ADT_StackContainer;

import stack.Stack;

public interface StackContainer<E> {

	public Stack<E> insert(E e);
	
	public void push(Stack<E> S,E e);
	
	public E  pop(Stack<E> S);
	
	public void remove(Stack<E> S);
	
	public boolean isEmpty();
	
	public int size();
	
}
