package ADT_ListContainer;

import position.Position;
import position.PositionList;

public interface InterfaceListContainer<E> {

	/** numero di liste conservate nel contenitore */
	public int Size();
	
	/** contenitore vuoto o no */
	public boolean isEmpty();
	
	/** inserisce L nel contenitore */
	public void insert(PositionList<E> L);
	
	/** inserisce l’elemento x in L, se L `e nel contenitore,dopo quello in position p. */
	public void insertAfter (PositionList<E> L,E el, Position<E> p);
	
	/** inserisce l’elemento x in L, se L `e nel contenitore,prima di quello in position p. */
	public void insertBefore (PositionList<E> L,E el , Position<E> p);
	
	/** cancella da L, se L `e nel contenitore, l’elemento di 	position p. */
	public void removeElement (PositionList<E> L, Position<E> p);
	
	/**  elimina (senza distruggere) la lista L dal contenitore */
	public void remove (PositionList<E> L);
	
}
