package ADT_EntryContainerLASD_12_07_2010;

import position.Position;
import priorityQueue.Entry;

public class MyEntry<K,V> implements Entry<K,V> {

	private K key;
	private V value;
	private Position<Entry<K,V>> location;
	
	
	public MyEntry(K k,V v){
		key = k;
		value=v;
		location=null;
	}
	
	public void setPosition(Position<Entry<K,V>> pos){
		location = pos;
	}
	
	public Position<Entry<K,V>> position(){
		return location;
	}
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}
