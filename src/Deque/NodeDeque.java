package deque;

import node.DLNode;
import exception.EmptyDequeException;

public class NodeDeque<E> implements Deque<E> {

	private int size=0;
	private DLNode<E> header,trailer;
	
	//costruttore
	public NodeDeque(){
		header=new DLNode<E>();
		trailer=new DLNode<E>();
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	//metodi di accesso
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E getFirst() throws EmptyDequeException {
		if(isEmpty())
			throw new EmptyDequeException("deque vuoto");
		return header.getNext().getElement();
	}

	public E getLast() throws EmptyDequeException {
		if(isEmpty())
			throw new EmptyDequeException("deque vuoto");
		return trailer.getPrev().getElement();
	}

	//metodi di modifica
	public void addFirst(E elem) {
		DLNode<E> nuovo = new DLNode<E>(elem,header,header.getNext());
		header.getNext().setPrev(nuovo);
		header.setNext(nuovo);
		size++;
	}

	public void addLast(E elem) {
		DLNode<E> nuovo = new DLNode<E>(elem,trailer.getPrev(),trailer);
		trailer.getPrev().setNext(nuovo);
		trailer.setPrev(nuovo);
		size++;
	}

	public E removeFirst() throws EmptyDequeException {
		if(isEmpty())
			throw new EmptyDequeException("deque vuoto");
		E elem = header.getNext().getElement();
		header.getNext().getNext().setPrev(header);
		header.setNext(header.getNext().getNext());
		size--;
		return elem;
	}

	public E removeLast() throws EmptyDequeException {
		if(isEmpty())
			throw new EmptyDequeException("deque vuoto");
		E elem = trailer.getPrev().getElement();
		trailer.getPrev().getPrev().setNext(trailer);
		trailer.setPrev(trailer.getPrev().getPrev());
		size--;
		return elem;
	}
	
	public String toString(){
		String s="";
		if(size==0)
			return s+="(header)<->(trailer)";
		s+="(header)<->[";
		DLNode<E> cur= header.getNext();
		while(cur!=trailer){
			s+=cur.getElement();
			if(cur.getNext()!=trailer)
				s+=", ";
			cur=cur.getNext();
		}
		return s+="]<->(trailer)";
	}

	
	
	public Deque<E> clone(){
		E element = null;
		NodeDeque<E> clone = new NodeDeque<E>();
		
		for(int i = 0; i<size();i++){
			element = removeFirst();
			clone.addLast(element);
			addLast(element);
		}
		
		return clone;
	}
	
	public Deque<E> reverse(){
		
		NodeDeque<E> clone = new NodeDeque<E>();
		NodeDeque<E> invertita = new NodeDeque<E>();
		
		clone = (NodeDeque<E>) clone();
		for(int i = 0; i<size();i++)
			invertita.addFirst(clone.removeFirst());
		return invertita;
	}
	
	public boolean equal(Deque<E> D){
		boolean result = true;
		if(size() !=  D.size())
			return false;
		if(getFirst() == null && D.getFirst() == null)
			return true;
		E elemento1 = null;
		E elemento2 = null;
		int k = size();
		for(int i=0; i<k; i++){
			elemento1 = removeFirst();
			elemento2 = D.removeFirst();
			addLast(elemento1);
			D.addLast(elemento2);
			if((elemento1 != elemento2) && (result == true))
				result = false;
		}
		return result;
	}
}
