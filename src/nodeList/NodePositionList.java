package nodeList;

import java.util.Iterator;

import node.DNode;
import position.Position;
import iterator.*;
import exception.BoundaryViolationException;
import exception.EmptyListException;
import exception.InvalidPositionException;

public class NodePositionList<E> implements PositionList<E>{
	protected int numElts;
	protected DNode<E> header, trailer;
	
	public NodePositionList() {
		numElts = 0;
		header = new DNode<E>(null,null,null);
		trailer = new DNode<E>(header,null,null);
		header.setNext(trailer);
		}
	
	public DNode <E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p == null) throw new InvalidPositionException("Posizione nulla passata a NodeList");
		if (p == header) throw new InvalidPositionException("Header non è una posizione valida");
		if (p == trailer) throw new InvalidPositionException("Trailer non è una posizione valida");
		try { 
			DNode <E>temp = (DNode<E>) p; // cast
			if ((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Posizione non appartenente ad una valida NodeList");
			return temp;
		}
		catch (ClassCastException e) {
			throw new InvalidPositionException("Posizione di tipo sbagliato per questo contenitore"); 
		}
	}
	
	public Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v.getPrev(),v, e);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return newNode;
		}

	public Position<E> addAfter(Position<E> p, E e)	throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts++;
		DNode<E> newNode = new DNode<E>(v,v.getNext(), e);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return newNode;
	}

	public void addFirst(E e) {
		numElts++;
		DNode<E> newNode = new DNode<E>(header,header.getNext(),e);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
	}

	public void addLast(E e) {
		numElts++;
		DNode<E> newNode = new DNode<E>(trailer.getPrev(),trailer,e);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElts--;
		E vElem = v.element();
		DNode<E> vPrev = v.getPrev();
		DNode<E> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		E elem=v.element();
		v.setElement(e);
		return elem;
	}

	public int size() {
		return numElts;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public Position<E> first() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("lista vuota");
		return header.getNext();
	}

	public Position<E> last() throws EmptyListException {
		if(isEmpty()) throw new EmptyListException("lista vuota");
		return trailer.getPrev();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v= checkPosition(p);
		if(v.getPrev()==header) throw new BoundaryViolationException("non posso retrocedere oltre l'inizio della lista");
		return v.getPrev();
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v= checkPosition(p);
		if(v.getNext()==trailer) throw new BoundaryViolationException("non posso avanzare oltre la fine della lista");
		return v.getNext();
	}
	
	public String toString(){
		String toReturn="[ ";
		if(!isEmpty()){
			Position<E> p = header.getNext();
			while(p!=last()){
				toReturn+= p.element()+", ";
				p=next(p);
			}
		toReturn+=last().element();
		}
		toReturn+=" ]";
		return toReturn;
	}
	
	public Iterable <Position <E>> positions(){
		PositionList<Position<E>> toReturn= new NodePositionList<Position<E>>();
		if(!isEmpty()){
			Position<E> current=first();
			for(int i=0; i<size()-1;i++){
				toReturn.addLast(current);
				current=next(current);
			}
			toReturn.addLast(last());
		}
		return toReturn;
	}

	public Iterator<E> iterator() {
		return new ElementIterator(this);
	}
	
	//inverte ricorsivamente la lista
	public void reverse(){
		if(first()==last())
			return;
		else{
			E tmp = first().element();
			remove(first());
			reverse();
			addLast(tmp);
			return;
		}
	}
}
