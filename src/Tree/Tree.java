package tree;
import position.Position;
import exception.*;

public interface Tree<E> extends Iterable<E> {
	public int size();
	public boolean isEmpty();
	public Iterable<Position<E>> positions();
	public E replace(Position<E> v, E e) throws InvalidPositionException;
	public Position<E> root() throws EmptyTreeException;
	
	//lancia BoundaryViolationException se v è la radice
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	
	//lancia InvalidPositionException anche se v è una foglia
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	
	public boolean isInternal(Position<E> v);
	public boolean isExternal(Position<E> v);
	public boolean isRoot(Position<E> v);
}
