package nodeList;

import position.Position;
import exception.InvalidPositionException;
import exception.EmptyListException;
import exception.BoundaryViolationException;

public interface PositionList<E> extends Iterable<E>{
	// Metodi generici
	public int size();
	public boolean isEmpty();
	// Metodi di aggiornamento
	public Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException;
	public Position<E> addAfter(Position<E> p, E e) throws InvalidPositionException;
	public void addFirst(E e);
	public void addLast(E e);
	public E remove(Position<E> p) throws InvalidPositionException;
	public E set(Position <E> p, E e) throws InvalidPositionException;
	// Metodi di accesso
	public Position <E> first() throws EmptyListException;
	public Position <E> last() throws EmptyListException;
	public Position <E> prev(Position <E> p) throws InvalidPositionException, BoundaryViolationException;
	public Position <E> next(Position <E> p) throws InvalidPositionException, BoundaryViolationException;
	
	public Iterable <Position <E>> positions();
}
