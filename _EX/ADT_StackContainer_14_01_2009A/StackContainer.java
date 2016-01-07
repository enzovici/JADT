package ADT_StackContainer_14_01_2009A;

import position.PositionList;
import stack.Stack;

public interface StackContainer<E> {

	/** crea una nuova pila avente come elementi gli elementi della lista L e la inserisce nel contenitore 
	 */
	public Stack<E> insert(PositionList<E> L);
	
	/** aggiunge alla pila S l’elemento 'e' (si tralasci l’implementazione dell’eccezione relativa al caso in cui S 
	 *  non sia nel contenitore)
	 */
	public Stack<E> add(Stack<E> S, E elem);
	
	/** rimuove dal contenitore la pila avente il maggior numero di elementi
	 */
	public void remove();
	
	/** restituisce la collezione iterabile delle pile che si trovano nel contenitore
	 */
	public Iterable<Stack<E>> elements();
	
	public int size();
	
	public boolean isEmpty();
}
