package ADT_EntryContainerLASD_30_06_10;

import position.Position;
import priorityQueue.Entry;

public class MyEntry<K,V> implements Entry<K,V> {

	
	private K key;
	private V value;
	private Position<Entry<K,V>> location;
	
	
	public MyEntry(K k,V v){
		key=k;
		value=v;
		location=null;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public Position<Entry<K,V>> position(){
		return location;
	}
	
	
	public void setPosition(Position<Entry<K,V>> e){
		location=e;
	}
	
	
}
