package stack;

import node.Node;
import exception.EmptyStackException;

public class NodeStack <E> implements Stack<E>{
	private Node<E> top=null;
	private int size=0;
	
	public int size(){return size;}
	
	public boolean isEmpty(){return(size==0);}
	
	public E pop()throws EmptyStackException{
		if(isEmpty()) 
			throw new EmptyStackException("stack vuoto");
		E toReturn=top.getElement();
		Node<E>tmp=top.getNext();
		top.setNext(null);
		top=tmp;
		size--;
		return toReturn;
	}
	
	public E top()throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("stack vuoto");
		return top.getElement();
	}
	
	public void push(E x){
		top=new Node<E>(x,top);
		size++;
	}
	
	public String toString(){
		String s="(top) [";
		if(isEmpty()){
			s+="] (bottom)";
			return s;
		}
		Node<E> cur=top;
		while(cur!=null){
			s+=cur.getElement();
			if(cur.getNext()!=null)
				s+=',';
			cur=cur.getNext();
		}
		s+="] (bottom)";
		return s;
	}
}
