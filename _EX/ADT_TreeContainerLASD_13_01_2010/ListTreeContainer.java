package ADT_TreeContainerLASD_13_01_2010;

import position.EmptyListException;
import position.InvalidPositionException;
import position.NodePositionList;
import position.Position;
import position.PositionList;
import tree.LinkedTree;
import tree.Tree;
import tree.TreeNode;

public class ListTreeContainer<E> implements TreeContainer<E> {

	private PositionList<Tree<E>> listaAlberi; 
	
	
	public ListTreeContainer(){
		listaAlberi = new NodePositionList<Tree<E>>();
	}
	
	/** crea un nuovo albero formato dalla sola radice (che memorizzerà l'elemento elem) e lo inserisce
	 *  nel contenitore (il nuovo albero viene restituito in output) */
	public Tree<E> insert(E elem) {
		
		LinkedTree<E> albero = new LinkedTree<E>();
		
		albero.addRoot(elem);
		listaAlberi.addLast(albero);
		mergeSort(listaAlberi);
		return albero;
	}
	
	
	/** aggiunge un nuovo figlio al vertice v dell'albero T e vi memorizza l'elemento elem */
	public Position<E> insertChild(Tree<E> T, Position<E> v, E elem)throws InvalidPositionException {
		
		Position<E> child = ((LinkedTree<E>) T).insertChild(v,elem);
		mergeSort(listaAlberi);
		
		return child;
		
		
	}
	
	
	/**  restituisce la lista degli alberi presenti nel contenitore */
	public PositionList<Tree<E>> elements()throws EmptyListException {
		if(listaAlberi.isEmpty())
			throw new EmptyListException("La lista iterabile è vuota!!");
		
		return listaAlberi;
	}

	
	/** rimuove dal contenitore l'albero che contiene il maggior numero di foglie */

	public void remove()throws EmptyListException{
		if(listaAlberi.isEmpty())
			throw new EmptyListException("La lista è vuota!!");
		
		listaAlberi.remove(listaAlberi.last());
	}
	
	/** Metodo che stampa tutti i nodi dell'albero contenuti nel contenitore di alberi.
	 *  
	 *  @return stampa
	 */
	public String toString(){
		String stampa="";
		for(Tree<E> a : listaAlberi){
			stampa+="[";
			for(Position<E> p : a.positions()){
				stampa+=p.element()+"-";
				}
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="]\n";
		}
			
		return stampa;
		
	}
	
	public int size(){
		return listaAlberi.size();
	}
	
	public boolean isEmpty(){
		return listaAlberi.isEmpty();
	}

	/** Conta ricorsivamente le foglie presenti nell'albero con la radice passata come parametro 
	 * @param 	T 	l'albero sul quale operare
	 * @param 	v 	la radice del sottoalbero
	 * @return 		il numero di foglie del sottoalbero */
	public int numberLeaves(LinkedTree<E> T,Position<E> v) throws InvalidPositionException{
		int i = 0;
		TreeNode<E> nodo = T.checkPosition(v);
		if(T.isExternal(v)) // caso base
			return 1;		// caso base
		else
			for(Position<E> p : nodo.getChildren())		// ricorsione
				i += numberLeaves(T,p);					// ricorsione
		return i;
	}
	
	/** 
	 * Il metodo MergeSort serve per ordinare la lista di Alberi, in modo da aggiornare le posizioni degli alberi
	 * all'interno della lista, questo serve per poter permettere la rimozione in O(1) in modo sicuro, accedendo
	 * semplicemente alla position memorizzata all'interno di ogni elemento (LinkedTree) della lista
	 * @param L la lista da ordinare
	 */
	private void mergeSort(PositionList<Tree<E>> L){
		int n = L.size();
		if(n<2)
			return;
		PositionList<Tree<E>> l1 = new NodePositionList<Tree<E>>();
		PositionList<Tree<E>> l2 = new NodePositionList<Tree<E>>();
		for(int i = 0; i < n/2 ; i++)
			l1.addLast(L.remove(L.first()));
		for(int i = 0; i < n/2 ; i++)
			l2.addLast(L.remove(L.first()));
		mergeSort(l1);
		mergeSort(l2);
		Merge(l1,l2,L);
	}
	
	private void Merge(PositionList<Tree<E>> l1,PositionList<Tree<E>> l2,PositionList<Tree<E>> L){
		while(!l1.isEmpty() && !l2.isEmpty())
			if(numberLeaves((LinkedTree<E>) l1.first().element(), l1.first().element().root()) <= numberLeaves((LinkedTree<E>) l2.first().element(), l2.first().element().root())){
				L.addLast(l1.remove(l1.first()));
			}
			else{
				L.addLast(l2.remove(l2.first()));
			}
		
		while(!l1.isEmpty()){
			L.addLast(l1.remove(l1.first()));
		}
		while(!l2.isEmpty()){
			L.addLast(l2.remove(l2.first()));
		}
	}
	
}
