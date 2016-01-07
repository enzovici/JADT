package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import arrayList.ArrayIndexList;
import arrayList.IndexList;

public class IndexListIterator<E> implements Iterator<E> {
	private IndexList<E> V;
	private int index = -1;

	
	@SuppressWarnings("unchecked")
	public IndexListIterator(E[]A){
		V = new ArrayIndexList<E>();
		for(int i=0; i<A.length; i++)
			V.add(i, A[i]);
		if(A.length > 0) //se lenght>0 allora ci sono elementi da scandire
			index = 0;
	}

	public boolean hasNext() {
		if(index>=0)
			return true;
		return false;
	}

	
	public E next() {
		if(!hasNext()) //se hasNext è falso lancia un'eccezione
			throw new NoSuchElementException("Nessun elemento da scandire");
		E toReturn = V.get(index);
		if(index == V.size()-1)
			index = -1;
		else 
			index++;
		return toReturn;
	}

	
	public void remove() throws UnsupportedOperationException {
		throw new 
		UnsupportedOperationException("remove");
	}
}
