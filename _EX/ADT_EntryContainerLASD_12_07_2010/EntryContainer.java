package ADT_EntryContainerLASD_12_07_2010;

import position.PositionList;
import priorityQueue.Entry;

public interface EntryContainer<K,V> {

	/** inserisce una nuova entrata con chiave k e valore v e restituisce l’entrata creata; */
	public Entry<K,V> add(K k,V v);
	
	/** se esiste una entrata e, la rimuove e restituisce il valore v ad essa associato, altrimenti restituisce null */
	public V remove(Entry<K,V> e);
	
	/** rimuove tutte le entrate con chiave k dove k è la più piccola chiave memorizzata e restituisce la collezione 
	 *  iterabile di tutte le entrate rimosse. Ad esempio, si supponga che il contenitore memorizzi entrate del tipo (x,v)
	 *  con chiave x€N e usi la consueta relazione <= per eseguire i confronti. Se il contenitore ha le	seguenti entrate: 
	 *  f(3; v1); (1; v2); (3; v3); (1; v4)g, il metodo remove() dovrà restituire la collezione iterabile 
	 *  < (1; v2); (1; v4) >   
	 */
	public PositionList<Entry<K,V>> remove();
	
	public int size();
	
	public boolean isEmpty();
}
