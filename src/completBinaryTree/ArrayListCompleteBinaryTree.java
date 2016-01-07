package completBinaryTree;

import arrayList.*;
import position.*;
import tree.*;

import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import exception.BoundaryViolationException;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import exception.NonEmptyTreeException;


public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E>{

	protected IndexList<BTPos<E>> T;
		
	protected static class BTPos<E> implements Position<E> {
		E element;
		int index; // indice
		
		public BTPos(E elt, int i) {
			element = elt;
			index = i;
		}
		public E element() { return element; }
		public int index() { return index; }
		public E setElement(E elt) { 
			E temp = element; 
			element = elt;
			return temp;
		}
		public String toString() {	return("[" + element + "," + index + "]");	}
	
	}
	/** Se v e` una posizione valida, fa il cast a BTPos, altrimenti lancia una eccezione.
	 * @param p la posizione da controllare
	 * @return  la BTPos
	 */
	@SuppressWarnings("unchecked")
	public BTPos<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null||!(p instanceof BTPos)) throw new InvalidPositionException("La posizione è invalida");
		return (BTPos<E>) p;
	}
	
	public ArrayListCompleteBinaryTree(){
		T = new ArrayIndexList<BTPos<E>>();
		T.add(0, null);
	}
	
	public Position<E> add(E elem) {
		BTPos<E> b = new BTPos<E>(elem,size()+1);
		T.add(size()+1, b);
		return b;
	}

	public void setT(IndexList<BTPos<E>> t) {
		T = t;
	}

	public E remove() throws EmptyTreeException{
		if(isEmpty()) throw new EmptyTreeException("L'albero è vuoto");			
		BTPos<E> b = T.remove(size());
		return b.element();
	}

	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		return (p.index()*2<=size());
	}

	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		return (p.index()*2+1<=size());
	}

	public Position<E> left(Position<E> v) throws InvalidPositionException,	BoundaryViolationException {
		BTPos<E> p = checkPosition(v);
		if(!hasLeft(v)) throw new BoundaryViolationException("Non esiste un figlio sinistro");
		return T.get(p.index()*2);
	}

	public Position<E> right(Position<E> v) throws InvalidPositionException,BoundaryViolationException {
		BTPos<E> p = checkPosition(v);
		if(!hasRight(v)) throw new BoundaryViolationException("Non esiste un figlio destro");
		return T.get(p.index()*2+1);
	}

	public Position<E> addRoot(E e) throws NonEmptyTreeException {
		if(!isEmpty())throw new NonEmptyTreeException("L'albero ha già una radice!"); 
		BTPos<E> p = new BTPos<E>(e, 1);
		T.add(1, p);
		return p;
	}

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		NodePositionList<Position<E>> lista = new NodePositionList<Position<E>>();
		if(hasLeft(p)){
			lista.addLast(left(p));
			if(hasRight(p))
				lista.addLast(right(p));
		}
		return lista;
	}

	/*** Metodo non implementato perchè inseriamo o il figlio a sinistra o quello a destra!!
	 * 
	 * @param v
	 * @param e
	 * @return
	 * @throws InvalidPositionException
	 */
	public Position<E> insertChild(Position<E> v, E e) throws InvalidPositionException {
		@SuppressWarnings("unused")
		BTPos<E> p = checkPosition(v);
		return null;
	}

	public boolean isEmpty() {
		return size()==0;
	}

	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		return hasLeft(p);
	}

	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		return p.index()==1;
	}

	/** Ritorna un iteratore sugli elementi dell'albero
	 * @return 		l'iteratore sugli elementi
	 */
	public Iterator<E> iterator() {
		PositionList<E> lista = new NodePositionList<E>();
		for(Position<E> p : positions() )
			lista.addLast(p.element());
		return lista.iterator();
	}

	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPos<E> p = checkPosition(v);
		if(p.index()==1) throw new BoundaryViolationException("La radice non ha padre!");
		if((p.index()%2)==0)
			return T.get(p.index()/2);
		else
			return T.get((p.index()-1)/2);
	}

	public Iterable<Position<E>> positions() {
		NodePositionList<Position<E>> lista = new NodePositionList<Position<E>>();
		inOrder(root(),lista);
		return lista;
	}
	
	/** Effettua ricorsivamente la visita inOrder sull'albero radicato in v
	 * @param v		la radice dell'albero
	 * @param 		la lista di posizioni	
	 */
	public void inOrder(Position<E> v,PositionList<Position<E>> lista){
		if(hasLeft(v))
			inOrder(left(v),lista);
		lista.addLast(v);
		if(hasRight(v))
			inOrder(right(v),lista);
	}

	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPos<E> p = checkPosition(v);
		E el = p.element();
		p.setElement(e);
		return el;
	}

	public Position<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("L'albero è vuoto!");
		return T.get(1);
	}

	public int size() {
		return T.size()-1;
	}
	
	public IndexList<BTPos<E>> getT() {
		return T;
	}
	
	public Position<E> sibling(Position<E> v){
		
		BTPos<E> figlio = checkPosition(v);
		
		if(figlio.index()==1) throw new BoundaryViolationException("Il nodo passato non ha fratelli!!");
		
		if(left(parent(v))==v){
			if(hasRight(parent(v)))
					return right(parent(v));
		}
		
		else 
			return left(parent(v));
	
		return null;
	}
	
}
