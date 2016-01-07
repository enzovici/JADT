package ADT_StackContainer_Appello_12_06_2009;

import position.PositionList;
import stack.Stack;

public interface StackContainer {

	/*** crea una nuova pila S contenente tutti gli interi in L (l’ordine dovrà essere tale che 
	 *   l’ultimo elemento di L vada nel top di S) e la inserisce nel contenitore.Restituisce la pila creata.
	 */
	public Stack<Integer> insert(PositionList<Integer> L);
	
	
	
	/*** crea una nuova pila T ottenuta con un push	dell’elemento e su S e la inserisce nel contenitore.
	 *   Restituisce la pila creata.
	 */
	public Stack<Integer> insert(Stack<Integer> S, Integer e); 
	
	
	
	/** rimuove dal contenitore la pila tale che la somma dei suoi elementi sia massima (se ci sono due o più pile 
	 *  con questa caratteristica, se ne rimuova una qualsiasi fra queste). Si restituisca in output la pila rimossa.
	 */
	public Stack<Integer> remove();
	
}
