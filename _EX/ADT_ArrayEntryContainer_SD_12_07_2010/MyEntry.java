package ADT_ArrayEntryContainer_SD_12_07_2010;

import priorityQueue.Entry;

public class MyEntry<K,V> implements Entry<K,V> {

	
	private K key;
	private V value;
	
	
	public MyEntry(K k,V v){
		key =k;
		value=v;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V v){
		value=v;
	}
	
	public void setKey(K k){
		key = k;
	}
	
}
