package ADT_TreeContainerLASD_13_01_2010;

import position.*;
import tree.*;

public interface TreeContainer<E> {

	/** crea un nuovo albero formato dalla sola radice (che memorizzerà l'elemento elem) e lo inserisce
	 *  nel contenitore (il nuovo albero viene restituito in output) */
	public Tree<E> insert(E elem);
	
	/** aggiunge un nuovo figlio al vertice v dell'albero T e vi memorizza l'elemento elem */
	public Position<E> insertChild(Tree<E> T,Position<E> v, E elem);
	
	/** rimuove dal contenitore l'albero che contiene il maggior numero di foglie */
	public void remove();
	
	/**  restituisce la lista degli alberi presenti nel contenitore */
	public PositionList<Tree<E>> elements();
}
