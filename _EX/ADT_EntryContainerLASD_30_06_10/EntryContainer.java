package ADT_EntryContainerLASD_30_06_10;

import priorityQueue.Entry;

public interface EntryContainer<K,V> {

	/** se non esiste una entrata con chiave k, inserisce una entrata con chiave k e valore v
	 *  e restituisce l'entrata creata, altrimenti restituisce null; */
	public Entry<K,V> add(K k,V v);
	
	/** se esiste una entrata 'e' la rimuove e restituisce il valore v ad essa associato, altrimenti
	 *  restituisce null; */
	public V remove(Entry<K,V> e);
	
	/** rimuove l'entrata con la più piccola chiave e ne restituisce il valore ad essa associato.*/
	public V remove();

	
}