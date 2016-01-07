package adaptablePriorityQueue;

import java.util.Comparator;

import position.Position;
import priorityQueue.HeapPriorityQueue;
import adaptablePriorityQueue.AdaptablePriorityQueue;
import exception.InvalidEntryException;
import exception.InvalidKeyException;
import entry.Entry;
import entry.MyEntry;

public class HeapAdaptablePriorityQueue<K,V> extends HeapPriorityQueue<K,V>
 implements AdaptablePriorityQueue<K,V> {
	

	public HeapAdaptablePriorityQueue(Comparator comp) {
	super(comp);
	}

		/** classe innestata per aggiungere la locazione  */
		protected static class LocationAwareEntry<K,V> extends MyEntry<K,V> implements Entry<K,V> {
			protected Position <Entry<K,V>> loc;
			public LocationAwareEntry(K k, V v) {
			super(k, v);
			}
			public LocationAwareEntry(K k, V v, Position pos) {
			super(k, v);
			loc = pos;
			}
			
			protected Position < Entry<K,V>> location() {
			return loc;
			}
			protected Position < Entry<K,V> >setLocation(Position< Entry<K,V>> pos) {
			Position<Entry<K,V>> oldPosition = location();
			loc = pos;
			return oldPosition;
			}
			protected K setKey(K k) {
			K oldKey = getKey();
			key = k;
			return oldKey;
			}
			protected V setValue(V v) {
			V oldValue = getValue();
			value = v;
			return oldValue;
			}
		}//FINE CLASSE INNESTATA

public Entry<K,V> insert (K k, V v) throws InvalidKeyException {
checkKey(k);
LocationAwareEntry<K,V> entry = new
LocationAwareEntry<K,V>(k,v);
Position <Entry<K,V>> z = heap.add(entry);
entry.setLocation(z);
upHeap(z);
return entry;
}



public Entry<K,V> remove(Entry<K,V> entry) throws
InvalidEntryException {
LocationAwareEntry<K,V> ee = checkEntry(entry);
Position < Entry<K,V>>p = ee.location();
if(size() == 1)
return (Entry<K,V>) heap.remove();
replaceEntry(p,(LocationAwareEntry<K,V>)heap.remove());
upHeap(p);
downHeap(p);
ee.setLocation(null);
return ee;
}

public K replaceKey(Entry<K,V> entry, K k)
throws InvalidEntryException
{
checkKey(k);
LocationAwareEntry<K,V> ee = checkEntry(entry);
K oldKey = ee.setKey(k);
upHeap(ee.location());
downHeap(ee.location());
return oldKey;
}

public V replaceValue(Entry<K,V> e, V value)
throws InvalidEntryException
{
LocationAwareEntry<K,V> ee = checkEntry(e);
return ee.setValue(value);
}



public void swap(Position<Entry<K,V>> u,
Position<Entry<K,V>> v) {
super.swap(u,v);
getEntry(u).setLocation(u);
getEntry(v).setLocation(v);
}


protected Position< Entry<K,V>> replaceEntry(Position<Entry<K,V>> v,
LocationAwareEntry<K,V> e) {
heap.replace(v,e);
return e.setLocation(v);
}


protected LocationAwareEntry<K,V> getEntry(Position < Entry<K,V> >p) {
return (LocationAwareEntry<K,V>) p.element();
}


protected LocationAwareEntry<K,V> checkEntry
(Entry<K,V> e)
throws InvalidEntryException
{
if(e == null || !(e instanceof LocationAwareEntry))
throw new InvalidEntryException("entrata non valida");
return (LocationAwareEntry) e;
}



}