package ADT_EntryContainerLASD_12_07_2010;

import java.util.Comparator;
import position.NodePositionList;
import position.Position;
import position.PositionList;
import priorityQueue.DefaultComparator;
import priorityQueue.Entry;

public class ListEntryContainer<K,V> implements  EntryContainer<K, V> {

	private PositionList<Entry<K,V>> lista;
	private Comparator<K> comp;
	
	
	public ListEntryContainer(){
		lista = new NodePositionList<Entry<K,V>>();
		comp = new DefaultComparator<K>();
	}
	
	
	/** inserisce una nuova entrata con chiave k e valore v e restituisce l’entrata creata; */
	public Entry<K, V> add(K k, V v) {
	
		MyEntry<K,V> entry = new MyEntry<K, V>(k, v);
		
		ordinaEntry(entry);
		
		return entry;
	}
	
	/** se esiste una entrata e, la rimuove e restituisce il valore v ad essa associato, altrimenti restituisce null */
	public V remove(Entry<K, V> e) {
		
		MyEntry<K,V> entry = (MyEntry<K, V>) e;
		lista.remove(entry.position());
		return entry.getValue();
	}

	/** rimuove tutte le entrate con chiave k dove k è la più piccola chiave memorizzata e restituisce la collezione 
	 *  iterabile di tutte le entrate rimosse. Ad esempio, si supponga che il contenitore memorizzi entrate del tipo (x,v)
	 *  con chiave x€N e usi la consueta relazione <= per eseguire i confronti. Se il contenitore ha le	seguenti entrate: 
	 *  f(3; v1); (1; v2); (3; v3); (1; v4)g, il metodo remove() dovrà restituire la collezione iterabile 
	 *  < (1; v2); (1; v4) >   
	 */
	public PositionList<Entry<K, V>> remove() {
		
		PositionList<Entry<K,V>> listaRimosse = new NodePositionList<Entry<K,V>>();
		
		Entry<K,V> entryRimossa = lista.remove(lista.first());
		listaRimosse.addLast(entryRimossa);
		
		for(Position<Entry<K,V>> e : lista.positions()){
			if(comp.compare(entryRimossa.getKey(),e.element().getKey())==0){
				listaRimosse.addLast(e.element());
				lista.remove(e);
			}
		}
		return listaRimosse;
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public int size() {
		return lista.size();
	}
	
	public String toString(){
		String stampa ="";
		
		for(Entry<K,V> e : lista){
			stampa+=e.getKey()+"-"+e.getValue()+" ";
		}
		return stampa;
	}
	private void ordinaEntry(Entry<K,V> entry){
		
		MyEntry<K,V> en = (MyEntry<K, V>) entry;
		for(Position<Entry<K,V>> e : lista.positions()){
			if(comp.compare(en.getKey(),e.element().getKey()) <= 0){
				lista.addBefore(e,en);
				en.setPosition(lista.prev(e));
				return;
			}
		}
		
		lista.addLast(en);
		en.setPosition(lista.last());
	}
}