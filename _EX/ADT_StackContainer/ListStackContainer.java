package ADT_StackContainer;

import position.*;
import stack.Stack;

public class ListStackContainer<E>  implements StackContainer<E>{

	private PositionList<Stack<E>> lista;
	
	
	public ListStackContainer(){
		lista = new NodePositionList<Stack<E>>(); 
	}
	
	
	public Stack<E> insert(E e) {
		
		MyStack<E> s = new MyStack<E>();
		s.push(e);
		lista.addLast(s);
		s.setPosition(lista.last());
		
		return s;
	}

	
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	
	public E pop(Stack<E> S) throws StackNotFoudException,StackEmptyException{
		
		for(Stack<E> stack : lista)
			if(stack.equals(S)){
				if(stack.isEmpty()) 
					throw new StackEmptyException("Lo stack è vuoto!!!");
				
				return  stack.pop();
			}
		throw new StackNotFoudException("Stack non trovato!!");
	}

	
	public void push(Stack<E> S, E e) throws StackNotFoudException {
		
		for(Stack<E> stack : lista)
			if(stack.equals(S)){
				stack.push(e);
				return;	
			}
		throw new StackNotFoudException("Stack non trovato!!");
	}

	
	public void remove(Stack<E> S) {
		
		MyStack<E> ms = (MyStack<E>)S;
	
		try{
		lista.remove(ms.position());
		}
		catch(Exception e){
			throw new StackNotFoudException("Stack non trovato!!");
		}
	}

	public int size() {
		return lista.size();
	}
}
