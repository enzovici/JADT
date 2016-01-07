package sequence;

import position.Position;
import node.DNode;
import nodeList.*;
import exception.BoundaryViolationException;
import exception.EmptyListException;
import exception.EmptySequenceException;
import exception.IndexOutOfBoundsException;
import exception.InvalidPositionException;

public class NodeSequence<E> extends NodePositionList<E> implements Sequence<E> {
	
	protected void checkIndex(int r, int n) throws IndexOutOfBoundsException{
		if(r<0 || r>=n)
			throw new IndexOutOfBoundsException("l' indice "+r+" è illegale");
	}

	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		DNode<E> n = new DNode<E>(null,null,null);
		DNode<E> m = new DNode<E>(null,null,null);
		n=checkPosition(atIndex(i));
		m=n.getNext();
		for(int j=0; j<size()-i;j++){
			m.setIndex(m.getIndex()+1);
			m=m.getNext();
		}
		return super.remove(n);
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		DNode<E> n;
		if(i==size()){ 
			n=new DNode<E>(trailer.getPrev(),trailer,e);
			trailer.getPrev().setNext(n);
			trailer.setPrev(n);
		}
		else{
			checkIndex(i,size());
			n=new DNode<E>(null,null,e);
			DNode<E> m=new DNode<E>(null,null,null);
			m=checkPosition(atIndex(i));
			n.setPrev(m.getPrev());
			n.setNext(m);
			m.getPrev().setNext(n);
			m.setPrev(n);
			for(int j=0;j<size()-i;j++){
				m.setIndex(m.getIndex()+1);
				m=m.getNext();
			}
		}
		n.setIndex(i);
		numElts++;
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		return set(atIndex(i),e);
	}

	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		return atIndex(i).element();
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public int size() {
		return numElts;
	}

	public Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> m = checkPosition(p);
		DNode<E> n = new DNode<E>(m.getPrev(),m,e);
		n.setIndex(m.getIndex());
		m.getPrev().setNext(n);
		m.setPrev(n);
		int k=m.getIndex();
		for(int i=0; i<size()-k; i++){
			m.setIndex(m.getIndex()+1);
			m=m.getNext();
		}
		numElts++;
		return n;
	}

	public Position<E> addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> m = checkPosition(p);
		DNode<E> n = new DNode<E>(m,m.getNext(),e);
		n.setIndex(m.getIndex()+1);
		m.getNext().setPrev(n);
		m.setNext(n);
		m=n.getNext();
		int k=n.getIndex();
		numElts++;
		for(int i=0; i<size()-k; i++){
			m.setIndex(m.getIndex()+1);
			m=m.getNext();
		}
		
		return n;
	}

	public void addFirst(E e) {
		DNode<E> n = new DNode<E>(header,header.getNext(),e);
		header.getNext().setPrev(n);
		header.setNext(n);
		n.setIndex(1);
		n=n.getNext();
		for(int i=0; i<size(); i++){
			n.setIndex(n.getIndex()+1);
		}
		numElts++;
	}

	public void addLast(E e) {
		super.addLast(e);
		trailer.getPrev().setIndex(size());
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> n = checkPosition(p);
		DNode<E> m = new DNode<E>(null,null,null);
		m=n.getNext();
		for(int i=0; i<size()-m.getIndex();i++){
			m.setIndex(m.getIndex()+1);
			m=m.getNext();
		}
		return super.remove(n);
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		return super.set(p, e);
	}

	public Position<E> first() throws EmptyListException {
		return super.first();
	}

	public Position<E> last() throws EmptyListException {
		return super.last();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		return super.prev(p);
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException,BoundaryViolationException {
		return super.next(p);
	}

	public E getFirst() throws EmptySequenceException {
		return first().element();
	}

	public E getLast() throws EmptySequenceException {
		return last().element();
	}

	public E removeFirst() throws EmptySequenceException {
		return remove(first());
	}

	public E removeLast() throws EmptySequenceException {
		return remove(last());
	}

	public Position<E> atIndex(int index) throws BoundaryViolationException {
		checkIndex(index,size());
		DNode<E> nodo;
		if(index<=size()/2){
			nodo=header.getNext();
			for(int i=0; i<index; i++)
				nodo=nodo.getNext();
		}
		else{
			nodo=trailer.getPrev();
			for(int i=1; i<size()-index; i++)
				nodo=nodo.getPrev();
		}
		return nodo;
	}

	public int indexOf(Position<E> position) throws InvalidPositionException {
		DNode<E> n= checkPosition(position);
		return n.getIndex();
	}
	
	public String toString(){
		String s="(first)[ ";
		DNode<E>n = header.getNext();
		if(isEmpty())
			return s+="](last)";
		for(int i=0; i<size()-1; i++){
			s+=n.element()+", ";
			n=n.getNext();
		}
		s+=n.element()+" ](last)";
		return s;
	}

}
