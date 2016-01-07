package ADT_StackContainer_14_01_2009A;

import stack.*;
import position.*;

public class MyStack<E> extends ArrayStack<E>{

	private Position<Stack<E>> location;
	
	
	public MyStack(){
		super();
		location=null;
	}
	
	public void setPosition(Position<Stack<E>> pos){
		location=pos;
	}
	
	public Position<Stack<E>> position(){
		return location;
	}
}
