package ADT_ArrayEntryContainerSD_30_06_2010;

import priorityQueue.DefaultComparator;
import priorityQueue.Entry;


@SuppressWarnings("all")
public class MyEntry<K,V> implements Entry<K,V> {

	
	private DefaultComparator<K> comp;
	private K key;
	private V value;
	
	public MyEntry(K k,V v){
		key=k;
		value=v;
		comp=null;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setKey(K k) {
		key = k;
	}

	public void setValue(V v) {
		value = v;
	}
	
}
