package ADT_ArrayEntryContainer_SD_12_07_2010;

import position.PositionList;
import priorityQueue.Entry;

public interface EntryContainer<K,V> {

	public PositionList<Entry<K,V>> searchAll(K k);
	
	public PositionList<V> remove();
	
	public Entry<K,V> add(K k,V v);
}
