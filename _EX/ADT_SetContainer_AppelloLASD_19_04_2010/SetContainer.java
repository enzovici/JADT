package ADT_SetContainer_AppelloLASD_19_04_2010;

import set.Set;

public interface SetContainer<E> {

	/** crea un nuovo insieme S = feg e lo inserisce nel contenitore. Restituisce l’insieme creato. */
	public Set<E> insert(E e);
	
	/** inserisce un nuovo elemento e nell’insieme S e restituisce il numero di elementi di S. Lancia un’eccezione 
	 *  nel caso S non sia nel contenitore. */
	public int insert(Set<E> S, E e);
	
	/** rimuove e restituisce un insieme avente minima cardinalità. Lancia un’eccezione nel caso il contenitore sia vuoto.*/
	public Set<E> removeSmallest();
}
