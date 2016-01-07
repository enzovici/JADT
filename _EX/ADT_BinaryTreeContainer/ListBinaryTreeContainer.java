package ADT_BinaryTreeContainer;

import position.*;
import tree.EmptyTreeException;
import binaryTree.BinaryTree;

public class ListBinaryTreeContainer<E> implements BinaryTreeContainer<E> {

	
	private PositionList<BinaryTree<E>> lista;
	private DefaultComparator comp;
	
	public ListBinaryTreeContainer(){
		lista = new NodePositionList<BinaryTree<E>>();
		comp= new DefaultComparator();
	}
	
	
	/** crea e inserisce nel contenitore un nuovo albero binario avente l’elemento 'e' come radice e gli elementi 
	 *  in L come figli della radice; il metodo dovrà restituire l’albero creato
	 */
	public BinaryTree<E> insert(E e, PositionList<E> L) {
		
		if(L.isEmpty())
			throw new EmptyListException("La lista di elementi passata è vuota!!!");
		
		MyBinaryTree<E> albero = new MyBinaryTree<E>();
		albero.addRoot(e);
		
		for(E ele : L){
			if(!albero.hasLeft(albero.root()))	
				albero.insertLeft(albero.root(), ele);
			else 
				if(!albero.hasRight(albero.root()))	
				albero.insertRight(albero.root(), ele);

			else 
				if(albero.hasLeft(albero.root()) && albero.hasRight(albero.root())){	
			
					for(Position<E> pos : albero.positions()){
						if(!albero.hasLeft(pos))
							albero.insertLeft(pos, ele);
						else
							if(!albero.hasRight(pos))
								albero.insertRight(pos, ele);
						}
					}
				}
		lista.addLast(albero);
		albero.setPosition(lista.last());
		return albero;
	}
	
	/** aggiunge all’albero binario T un nuovo nodo avente 'e' come elemento,il nuovo nodo dovrà essere figlio di u
	 */
	public void add(BinaryTree<E> T, Position<E> u, E e) {
		
		MyBinaryTree<E> albero =(MyBinaryTree<E>) T;
		if(albero.isEmpty())
			throw new EmptyTreeException("L'albero passato in input al metodo è vuoto!!!");
		
		if(albero.isExternal(u))
		albero.insertChild(u,e);
	}

	
	/** restituisce la collezione iterabile di tutte le foglie di T ordinate secondo una visita inorder.
	 */
	public Iterable<Position<E>> leaves(BinaryTree<E> T) {
		MyBinaryTree<E> albero = (MyBinaryTree<E>) T;
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();
		for(Position<E> pos : albero.positions()){
			if(albero.isExternal(pos)==true){
				System.out.print(pos.element()+" ");
				lista.addLast(pos);
		}
		}
		return lista;
	
	}

	/** rimuove tutti gli alberi binari con altezza minore o uguale a i 
	 */
	public void remove(int i) {
		
		for(Position<BinaryTree<E>> a : lista.positions()){
			int altezza = altezzaAlbero(a.element(),a.element().root());
				if(comp.compare(i,altezza)<=0)
				lista.remove(a);
		}
		
		
	}
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public Iterable<Position<E>> position(BinaryTree<E> albero) {
		
		for(BinaryTree<E> pos : lista)
			if(pos==albero)
				return pos.positions();
				
		return null;
	}

	public int size() {
		return lista.size();
	}
	
	
	/** Metodo che restituisce l'altezza dell'albero passandogli in input al metodo 
	 *  una posizione dove iniziare la ricerca.
	 * 
	 * @param pos
	 * @return altezza
	 */
	public int altezzaAlbero(BinaryTree<E> albero ,Position<E> pos){
	
		
		if(albero.isExternal(pos))
			return 0;
	
		int sinistro = 0;
		int destro = 0;
		
		if(albero.hasLeft(pos))
			sinistro=altezzaAlbero(albero,albero.left(pos));
	
		if(albero.hasRight(pos))
			destro=altezzaAlbero(albero,albero.right(pos));
		
		return 1+Math.max(sinistro,destro);
	}

}
