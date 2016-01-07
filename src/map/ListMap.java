package map;

import java.util.Iterator;

import position.Position;
import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import exception.InvalidKeyException;


public class ListMap<K,V> implements Map<K,V> { 
	 
private PositionList<Entry<K,V>> L; 
 

protected static class MyEntry <K,V>implements Entry<K,V> 
{ 
 protected K key; 
 protected V value; 
 public MyEntry(K k, V e) { 
 key = k; value = e; 
 } 
 public K getKey() { return key; } 
 public V getValue() { return value; } 
} 



public ListMap(){ 
 L =new NodePositionList<Entry<K,V>>(); 
}

@Override
public int size() {
	
	return L.size();
}

@Override
public boolean isEmpty() {
	return (L.size()==0);
}

@Override
public V put(K key, V value) throws InvalidKeyException { 

	checkKey(key); 
 for(Position<Entry<K, V>> p: L.positions()){ 
 Entry<K,V> e= p.element(); 
 if(e.getKey().equals(key)){ 
	 V v = e.getValue();
 L.set(p, new MyEntry<K,V>(key,value)); 
 return v; 
} } 
 L.addLast(new MyEntry<K,V>(key,value)); 
 return null; 
}



@Override // complessità O(size)
public V get(K key) throws InvalidKeyException{ 
	 checkKey(key); 
	 for(Position<Entry<K,V>> p: L.positions()){ 
	 Entry<K,V> e= p.element(); 
	 if(e.getKey().equals(key)) return e.getValue(); 
	 } 
	 return null; 
	} 

@Override
public V remove(K key) throws InvalidKeyException { 
checkKey(key); 
 for(Position<Entry<K,V>> p: L.positions()){ 
 Entry<K,V> e= p.element(); 
 if(e.getKey().equals(key)){ 
 V v = e.getValue() ;
 L.remove(p); 
 return v; 
}} 
 return null; 
}

public Iterable<K> keys() {
	PositionList<K> keys = new NodePositionList<K>();
	Iterable<Entry<K,V>> entries = this.entries();
	for(Entry<K,V> p: entries){
		keys.addLast(p.getKey());
	}
	return keys;
}

public Iterable<V> values() {
	PositionList<V> values = new NodePositionList<V>();
	Iterable<Entry<K,V>> entries = this.entries();
	for(Entry<K,V> p: entries){
		values.addLast(p.getValue());
	}
	return values;
}

public Iterable<Entry<K,V>> entries() {
	return L;
}


public String toStringKey(){
	String str = "";
	Iterator<K> chiavi = keys().iterator();
	while(chiavi.hasNext()){
		str += chiavi.next();
		if(chiavi.hasNext())
			str += ", ";
	}
	return str;
}

public String toStringValue(){
	String str = "";
	Iterator<V> valori = values().iterator();
	while(valori.hasNext()){
		str += valori.next();
		if(valori.hasNext())
			str += ", ";
	}
	return str;
}

public String toStringKeyValue(){
	String str = "";
	Iterator<V> valori = values().iterator();
	Iterator<K> chiavi = keys().iterator();
	while(valori.hasNext()){
		str += chiavi.next() +": " + valori.next();
		if(valori.hasNext())
			str += ", ";
	}
	return str;
}

public String toString(){
	String str = "";
	Iterator<Entry<K,V>> entries = entries().iterator();
	while(entries.hasNext()){
		Entry<K,V> e = entries.next();
		str += e.getKey() +": " + e.getValue();
		if(entries.hasNext())
			str += ", ";
	}
	return str;
}


protected void checkKey(K k) {
	
	if (k == null) throw new InvalidKeyException("Chiave invalida: null.");
	}


}