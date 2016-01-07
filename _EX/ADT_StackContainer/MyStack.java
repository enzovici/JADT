package ADT_StackContainer;

import position.Position;
import stack.ArrayStack;
import stack.Stack;

public class MyStack<E> extends ArrayStack<E> implements MyStackPosition<E> {

	private Position<Stack<E>> location;
	
	
	public MyStack(){
		super();
		location=null;
	}
	
	public Position<Stack<E>> position() {
		return location;
	}

	public void setPosition(Position<Stack<E>> p) {
		location=p;
	}

	public E element() {
		return null;
	}

}
