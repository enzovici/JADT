package queue;

import node.Node;
import exception.EmptyQueueException;



public class NodeQueue<E> implements Queue<E> {
	protected Node<E> head, tail;
	protected int size;
	
	public NodeQueue(){
		head=null;
		tail=null;
		size=0;
	}

	public void enqueue(E x) {
		Node<E> nodo= new Node<E>(x,null);
		if(size!=0)
			tail.setNext(nodo);
		else
			head=nodo;
		tail=nodo;
		size++;
	}

	public E dequeue() throws EmptyQueueException {
		if(size==0) throw new EmptyQueueException("coda vuota");
		E elem= head.getElement();
		head=head.getNext();
		size--;
		if(size==0)
			tail=head;
		return elem;
	}

	public E front() throws EmptyQueueException {
		if(size==0) throw new EmptyQueueException("coda vuota");
		return head.getElement();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size()==0);
	}
	
	
	
	public String toString(){
		String s="(head) [";
		if(isEmpty()){
			s+="] (tail)";
			return s;
		}
		Node<E> cur=head;
		while(cur!=null){
			s+=cur.getElement();
			if(cur!=tail)
				s+=", ";
			cur=cur.getNext();
		}
		s+="] (tail)";
		return s;
	}
}
