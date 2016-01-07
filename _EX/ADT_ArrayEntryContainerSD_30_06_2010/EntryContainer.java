package ADT_ArrayEntryContainerSD_30_06_2010;

import priorityQueue.Entry;

public interface EntryContainer<K,V> {

	public int size();
	
	public boolean isEmpty();
	
	public Entry<K,V> add(K k,V v);	
	
	public V search(K k);
	
	public V remove();
	
}
