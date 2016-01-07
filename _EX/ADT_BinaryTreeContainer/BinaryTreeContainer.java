package ADT_BinaryTreeContainer;

import position.*;
import binaryTree.*;

public interface BinaryTreeContainer<E> {

	/** crea e inserisce nel contenitore un nuovo albero binario avente l’elemento 'e' come radice e gli elementi 
	 *  in L come figli della radice; il metodo dovrà restituire l’albero creato
	 */
	public BinaryTree<E> insert(E e, PositionList<E> L);
	
	/** aggiunge all’albero binario T un nuovo nodo avente 'e' come elemento,il nuovo nodo dovrà essere figlio di u
	 */
	public void add(BinaryTree<E> T, Position<E> u, E e);

	
	/** rimuove tutti gli alberi binari con altezza minore o uguale a i 
	 */
	public void remove(int i);
	
	
	/** restituisce la collezione iterabile di tutte le foglie di T ordinate secondo una visita inorder.
	 */
	public Iterable<Position<E>> leaves(BinaryTree<E> T);
	
	public int size();
	
	public boolean isEmpty();
}
