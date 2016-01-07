package ADT_ListContainer;

import position.InvalidPositionException;
import position.NodePositionList;
import position.Position;
import position.PositionList;

public class ListContainer<E> implements InterfaceListContainer<E> {

	
	private PositionList<PositionList<E>> lista;
	
	
	public ListContainer(){
	     lista = new NodePositionList<PositionList<E>>();
	}
	
	
	/** inserisce L nel contenitore */
	public void insert(PositionList<E> L) {
		
		MyPositionList<E> listaL = (MyPositionList<E>) L;
		lista.addLast(L);
		listaL.setPosition(lista.last());
		
	}

	/** inserisce l’elemento el in L, se L è nel contenitore,dopo quello in position p. */
	public void insertAfter(PositionList<E> L, E el, Position<E> p)throws InvalidPositionException {
	
		MyPositionList<E> list = (MyPositionList<E>) L;
		if(list.position()==null)
			throw new InvalidPositionException("La lista passata non si trova nel contenitore!!");
		
		list.addAfter(p, el);
		
	}

	/** inserisce l’elemento x in L, se L `e nel contenitore,prima di quello in position p. */
	public void insertBefore(PositionList<E> L, E el, Position<E> p) {
		
		MyPositionList<E> list = (MyPositionList<E>) L; 
		if(list.position()==null)
			throw new InvalidPositionException("La lista passata non si trova nel contenitore!!");
		
		list.addBefore(p, el);
	}


	/**  elimina (senza distruggere) la lista L dal contenitore */
	public void remove(PositionList<E> L) {
		
		MyPositionList<E> list = (MyPositionList<E>) L;
		lista.remove(list.position());
	}


	/** cancella da L, se L è nel contenitore, l’elemento di position p. */
	public void removeElement(PositionList<E> L, Position<E> p) {
		
		MyPositionList<E> list = (MyPositionList<E>) L;
		if(list.position()==null)
			throw new InvalidPositionException("La lista passata non si trova nel contenitore!!");
		
		list.remove(p);
		
	}
	
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}


	public int Size() {
		return lista.size();
	}
}
