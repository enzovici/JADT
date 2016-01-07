package ADT_SetContainer;

import position.PositionList;
import set.Set;

public interface SetContainer<E> {

	/** restituisce la collezione iterabile di tutti gli elementi (senza ripetizioni)
	che si trovano negli insiemi contenuti nel contenitore; */
	public Iterable<E> elements();
	
	/** prende due liste L1 e L2, crea un nuovo insieme, avente come elementi gli elementi di L1 e L2, 
	 *  lo inserisce nel contenitore e lo restituisce in output;*/
	public Set<E> insert(PositionList<E> L1, PositionList<E> L2);
	
	/** rimuove dal contenitore l’insieme avente il maggior numero di elementi e restituisce la collezione 
	 *  iterabile degli elementi dell’insieme rimosso; */
	public Iterable<E> remove();
	
}
