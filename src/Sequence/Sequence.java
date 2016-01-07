package sequence;

import position.Position;
import nodeList.*;
import arrayList.*;
import exception.*;

public interface Sequence<E> extends IndexList<E>, PositionList<E> {
	
	public E getFirst()	throws EmptySequenceException;
	public E getLast() throws EmptySequenceException;
	public E removeFirst() throws EmptySequenceException;
	public E removeLast() throws EmptySequenceException; 
	
	//Metodi ponte
	public Position<E> atIndex(int index) throws BoundaryViolationException;
	public int indexOf(Position <E> position) throws InvalidPositionException;
		
}
