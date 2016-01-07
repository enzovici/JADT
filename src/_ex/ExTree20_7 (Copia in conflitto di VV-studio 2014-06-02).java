package _ex;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;
import tree.LinkedTree;
import tree.Tree;

public class ExTree20_7 {

	/**
	 * .3. [25 punti] Scrivere la funzione
		public static <E> Position<E>findElt(Tree<E> T, E x)
		nella classe ExTree_20_7 fornita sul dischetto.
		Istruzioni per lo svolgimento dell’esercizio: 
		• La funzione deve effettuare una visita ricorsiva preorder dell’albero T e restituire in 
		output la position del primo nodo incontrato contenente x. Se nessun nodo dell’albero 
		contiene l’elemento x allora la funzione restituisce null.
		• La funzione deve soddisfare i seguenti requisiti:
		a. deve arrestare la visita non appena incontra un nodo contenente x 
		b. ad eccezione di children(), NON deve invocare funzioni che restituiscono o 
		utilizzano collezioni/iteratori di uno o più nodi dell’albero.
		Nel caso in cui non venga soddisfatto il requisito a la funzione sarà valutata al massimo 18
		punti. Nel caso in cui non vengano soddisfatti entrambi i requisiti a e b la funzione sarà 
		valutata al massimo 12 punti.
		• Se l’albero è vuoto la funzione deve lanciare l’eccezione EmptyTreeException.
		La classe di test ExTree_20_7 deve essere inserita nel pacchetto in cui si trova l’interfaccia Tree.
	 */
	public static void main(String[] args) {
		//riempio l'albero
		LinkedTree<String> T = new LinkedTree<String>();
		
		Position<String> last = T.addRoot("a");
		T.addChild("b", last);
		Position<String> last2 = T.addChild("c", last);
		last = T.addChild("d", last);
		
		T.addChild("e", last2);
		T.addChild("f", last2);
		
		T.addChild("g", last);
		T.addChild("h", last);
		
		
		Position<String> result = findElt(T,"e");
		if(result == null)System.out.println("nessun elemento trovato");
		else System.out.println(result.element() + " trovato!");
		
	}

	
	public static <E> Position<E> findElt(Tree<E> T, E x){
		Position<E> p = preorderSearch(T,T.root(),x);
		return p;
	}
	
	public static <E> Position<E> preorderSearch(Tree<E> T,Position<E> n, E x){
		System.out.println("leggo: " +n.element());
		if(n.element().equals(x)){
			
			return n;
		}
		if(T.isExternal(n))return null;
		NodePositionList<Position<E>> p = (NodePositionList<Position<E>>) T.children(n);
		for(Position<E> e : p){
			
			Position<E> tmp = preorderSearch(T,e,x);
			if(tmp != null)return tmp;
		}
		return null;
		
		
	}
	
	
	

		 
		 
	 }
	
}
