package ADT_EntryContainerLASD_30_06_10;

import position.*;
import priorityQueue.Entry;


public class ListEntryContainer<K,V> implements EntryContainer<K,V> {

	
	private PositionList<Entry<K,V>> list;
	private DefaultComparator<K> comp;
	
	
	public ListEntryContainer(){
		list = new NodePositionList<Entry<K,V>>();
		comp=new DefaultComparator<K>();
	}
	
	
	public void ordinaKeyLista(Entry<K,V> en){

		MyEntry<K,V> me = (MyEntry<K,V>) en;
		
		for(Position<Entry<K,V>> pe : list.positions())
			if(comp.compare(me.getKey(), pe.element().getKey())<0){
				list.addBefore(pe,me);
				me.setPosition(list.prev(pe));
				return; 
			}
		list.addLast(me);
		me.setPosition(list.last());
	}
	
	
	/** se non esiste una entrata con chiave k, inserisce una entrata con chiave k e valore v
	 *  e restituisce l'entrata creata, altrimenti restituisce null; */
	public Entry<K, V> add(K k, V v) {
		
		for(Entry<K,V> e : list){
			if(e.getKey() == k)
				return null;
		}
		
		MyEntry<K,V> myEntry = new MyEntry<K,V>(k,v);
		ordinaKeyLista(myEntry);
		
		return myEntry;
	}

	/** se esiste una entrata 'e' la rimuove e restituisce il valore v ad essa associato, altrimenti
	 *  restituisce null; */
	public V remove(Entry<K, V> e) {
		
		MyEntry<K,V> en = (MyEntry<K, V>) e;
		list.remove(en.position());
		
		return en.getValue();
	}

	/** rimuove l'entrata con la più piccola chiave e ne restituisce il valore ad essa associato.*/
	public V remove() {
		
		MyEntry<K,V> me =(MyEntry<K, V>) list.first().element();
		Position<Entry<K,V>> littleKey = list.first();
		list.remove(littleKey);
		
		return me.getValue();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public int size(){
		return list.size();
	}
	
	public String toString(){
		String stampa="";
		for(Entry<K,V> e : list)
			stampa+=e.getKey()+"-"+e.getValue()+" ";
	
		return stampa;
	
	}
	
}
