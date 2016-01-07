package ADT_SetContainerLASD_14_01_2009B;

import java.util.Comparator;
import position.InvalidPositionException;
import position.NodePositionList;
import position.Position;
import position.PositionList;
import set.Set;

public class ListSetContainer<E> implements SetContainer<E> {

	
	private PositionList<Set<E>> lista;
	private Comparator<Integer> comp;
	
	
	public ListSetContainer(){
		lista = new NodePositionList<Set<E>>();
		comp = new DefaultComparator<Integer>();
	}
	
	/** crea un nuovo insieme avente come elementi gli elementi della lista L e lo inserisce nel contenitore
	 */
	public Set<E> insert(PositionList<E> L) {

		MySet<E> ins = new MySet<E>();
		
		for(E elem : L)
			ins.insert(elem);
		
		ordinaInsiemi(ins);
		return ins;
	}

	/** aggiunge all’insieme S tutti gli elementi che sono nella lista L (si tralasci l’implementazione dell’eccezione 
	 *  relativa al caso in cui S non sia nel contenitore)
	 */
	public void add(Set<E> S, PositionList<E> L) {
	
		MySet<E> ins = (MySet<E>) S;
		if(ins.position()==null)
			throw new InvalidPositionException("L'insieme non è presente nel contenitore!!!");
		
		for(E elem : L)
			ins.insert(elem);
		
		lista.remove(ins.position());
		ordinaInsiemi(ins);
	}

	/** rimuove dal contenitore l’insieme avente il minor numero di elementi e restituisce la lista degli elementi 
	 *  dell’insieme rimosso
	 */
	public PositionList<E> remove() {

		PositionList<E> listaToRemove = lista.first().element().elements();
		lista.remove(lista.first());
		
		return listaToRemove;
	}

	/** restituisce la collezione iterabile degli insiemi che si trovano nel contenitore
	 */
	public Iterable<Set<E>> elements() {
		return lista;
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public int size() {
		return lista.size();
	}
	
	public String toString(){
		
		String stampa="";
		for(Set<E> ins : lista){
			stampa+="[";
			for(E elem : ins.elements())
				stampa+=elem+" ";
			
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="]";
		}
		return stampa;
	}

	private void ordinaInsiemi(Set<E> s){
		
		MySet<E> ins = (MySet<E>) s;
		for(Position<Set<E>> pos : lista.positions())
			if(comp.compare(ins.size(),pos.element().size()) <= 0){
				lista.addBefore(pos,ins);
				ins.setPosition(lista.prev(pos));
				return;
			}
		
		lista.addLast(ins);
		ins.setPosition(lista.last());
	}
}