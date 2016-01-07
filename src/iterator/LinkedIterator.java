package iterator;

import java.util.Iterator;

import node.Node;
import exception.*;

public class LinkedIterator<E> implements Iterator<E>{
	private Node <E> head;
	private int size;
	
	//il costruttore prende in input un array contenente gli elementi della collezione
	public LinkedIterator(E[] A){
		head=null;
		size=A.length;
		for(int i=size-1; i>=0; i--){
			Node<E>tmp= new Node(A[i],head);
			head=tmp;
		}
	}
	
	public boolean hasNext(){
		return (size>0);
	}
	
	public E next() throws NoSuchElementException{
		if(!hasNext())
			throw new NoSuchElementException("nessun altro elemento");
		E toReturn=head.getElement();
		head=head.getNext();
		size--;
		return toReturn;
	}
	
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("remove");
	}
}
