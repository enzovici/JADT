package ADT_SetContainer;

import position.NodePositionList;
import position.Position;
import position.PositionList;
import set.ListSet;
import set.Set;

public class ListSetContainer<E> implements  SetContainer<E>{

	private PositionList<Set<E>> listaSet;
	
	
	public ListSetContainer(){
		listaSet = new NodePositionList<Set<E>>();
	}
	
	
	
	public void ordinaInsiemi(Set<E> Insieme){
		
		for(Position<Set<E>> set : listaSet.positions())
			if(Insieme.size() <= set.element().size()){
				listaSet.addBefore(set,Insieme);
			return;
			}
		 
		listaSet.addLast(Insieme);
	}
	
	
	
	
	/** prende due liste L1 e L2, crea un nuovo insieme, avente come elementi gli elementi di L1 e L2, 
	 *  lo inserisce nel contenitore e lo restituisce in output;*/
	public Set<E> insert(PositionList<E> L1, PositionList<E> L2) {

		ListSet<E> set = new ListSet<E>();
		
		for(E elem1 : L1)
			set.insert(elem1);
		
		for(E elem2 : L2)
			set.insert(elem2);
	
		ordinaInsiemi(set);
		
		return set;
	}

	
	/** restituisce la collezione iterabile di tutti gli elementi (senza ripetizioni)
	che si trovano negli insiemi contenuti nel contenitore; */
	public Iterable<E> elements() {
		
		ListSet<E> ins = (ListSet<E>) listaSet.first().element();
		
		for(Set<E> s :listaSet)
			ins.union(s);
		
		return ins.elements();
	}


	/** rimuove dal contenitore l’insieme avente il maggior numero di elementi e restituisce la collezione 
	 *  iterabile degli elementi dell’insieme rimosso; */
	public Iterable<E> remove() {
		
		Iterable<E> listaSetRimosso =listaSet.last().element().elements();
		
		listaSet.remove(listaSet.last());
		
		return listaSetRimosso;
	}

}
