package arrayList;
import exception.IndexOutOfBoundsException;

public interface IndexList<E> {
	
	//restituisce e rimuove l’elemento di indice i e lancia un’eccezione se i<0 oppure i>n-1
	public E remove(int i) throws IndexOutOfBoundsException;
	
	//inserisce l’elemento di indice i e lancia un’ eccezione se i<0 oppure i>n
	public void add(int i, E e) throws IndexOutOfBoundsException;

	//rimpiazza con e l’elemento di indice i restituendolo in output e lancia un’eccezione se i <0 oppure i>n-1
	public E set(int i,E e) throws IndexOutOfBoundsException;
	
	//restituisce l’elemento di indice i e lancia un’ eccezione se i<0 oppure i>n-1
	public E get(int i) throws IndexOutOfBoundsException;
	
	public boolean isEmpty();
	
	public int size();
}
