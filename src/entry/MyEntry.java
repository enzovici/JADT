package entry;

public class MyEntry<K,V> implements Entry<K,V>{

	protected K k; // chiave
	protected V v; // valore
	 
	public MyEntry(K key, V value) {
		k = key; v = value;
	} 
	
	// metodi dell’interfaccia
	
	
	public K getKey() {
		return k;
	}
	
	public V getValue() { 
		return v;
	} 
	 
	public String toString() { 
		return "(" + k + "," + v + ")"; 
	}

	



}
