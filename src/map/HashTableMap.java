package map;

import java.util.Random;

import node.Node;
import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import exception.InvalidKeyException;

@SuppressWarnings("all")

public class HashTableMap<K,V> implements Map<K,V> {

	
	protected Entry<K,V> AVAILABLE = new HashEntry<K,V>(null, null);
	protected int n = 0; // numero di entrate nella mappa
	protected int prime, capacity; // prime factor e capacita` del bucket array
	protected Entry<K,V>[] bucket;// il bucket array
	protected int scale, shift; // i fattori shift e scale
	
	/** Crea una tabella hash con prime factor 109345121 e capacita` 1024. */
	public HashTableMap(){ 
		this(109345121,1024); 
		}
	
	/** Crea una tabella hash con prime factor 109345121 e capacita data. */
	public HashTableMap(int cap) {
		this(109345121, cap);
		}
	
	/** Crea una tabella hash con prime factor e capacita` dati. */
	public HashTableMap(int p, int cap) {
	
		prime = p;
		capacity = cap;
		bucket = (Entry<K,V>[]) new Entry[capacity]; // safe cast
		Random rand = new Random();
		scale = rand.nextInt(prime-1) + 1; //num. casuale compreso tra 1 e prime-1
		shift = rand.nextInt(prime); //num. casuale compreso tra 0 e prime-1
	}
	
	protected void checkKey(K k) {
		
		if (k == null) throw new InvalidKeyException("Chiave invalida: null.");
		}
		
	/** funzione di compressione */
	public int hashValue(K key) {
		//calcola il valore hash con il metodo mad
		return (int)((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
		}
		
	/** Restituisce una collezione iterable contenente tutte le chiavi. */
	public Iterable<K> keys() {
		
		PositionList<K> keys = new NodePositionList<K>();
		
		for (int i=0; i < capacity; i++)
			if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
				keys.addLast(bucket[i].getKey());
		
		return keys;
		}
	
	/** Metodo ausiliario di ricerca – restituisce l'indice della chiave in
	* input, se la chiave viene trovata, oppure il valore negativo -(a + 1)
	* (se la chiave non esiste nella tabella), dove a e` l'indice della
	* prima cella vuota o disponibile trovata. */
	protected int findEntry(K key) throws InvalidKeyException {
		
		int avail = -1;
		checkKey(key);
		int i = hashValue(key);
		int j = i;
		
			do {
				Entry<K,V> e = bucket[i];
					if ( e == null) {
							if (avail < 0)
								avail = i; // la cella i e` la prima cella disponibile
					break; // la chiave non e` nella tabella
				}
		
			if (key.equals(e.getKey())) // se troviamo la chiave...
				
				return i; // restituiamo l'indice della chiave trovata
		
			if (e == AVAILABLE) {
				if (avail < 0)
					avail = i; // la cella i e` la prima cella disponibile
			}
		
			i = (i + 1) % capacity; // continua la ricerca
			}
			
			while (i != j);
			
		return -(avail + 1); // avail e` la prima cella vuota o AVAILABLE
		}
	
	
	public V get (K key) throws InvalidKeyException {
	
		int i = findEntry(key);
		
		if (i < 0) 
			return null; // se i<0 la chiave non esiste
	
		return bucket[i].getValue();
	}
	
	public V put (K key, V value) throws InvalidKeyException {
	
		int i = findEntry(key); //trova l'appropriata cella per questa entrata
	
			if (i >= 0) // questa chiave ha gia` un valore nella tabella
				return ((HashEntry<K,V>) bucket[i]).setValue(value); // setta il nuovo valore
			
			if (n >= capacity/2) {
				rehash(); // rehash per mantenere il load factor <= 0.5
				i = findEntry(key); //trova l'appropriata cella per questa entrata
			}
	
			bucket[-i-1] = new HashEntry<K,V>(key, value);
			n++;
	
		return null; // non e` stato trovato alcun valore precedente
	}
	
	
	protected void rehash() {
		
		capacity = 2*capacity;
		Entry<K,V>[] old = bucket;
		
		bucket = (Entry<K,V>[]) new Entry[capacity]; // il nuovo bucket
		
		Random rand = new Random();
		
		scale = rand.nextInt(prime-1) + 1; // new hash scaling factor
		shift = rand.nextInt(prime); // new hash shifting factor
		
		for (int i = 0; i < old.length; i++) {
			Entry<K,V> e = old[i];
			
			if ((e != null) && (e != AVAILABLE)) { // una entrata valida
				int j = - 1 - findEntry(e.getKey());
				bucket[j] = e;
			      }
			}
	}
	
	
	public V remove (K key) throws InvalidKeyException {
		
		int i = findEntry(key); // cerca la chiave key
		
			if (i < 0)
				return null; // niente da rimuovere in questo caso
		
			V toReturn = bucket[i].getValue();
			bucket[i] = AVAILABLE; // disattiva la cella i
			n--;
		
		return toReturn;
	}

	public Iterable<Entry<K, V>> entries() {
		
		PositionList<Entry<K,V>> list = new NodePositionList<Entry<K,V>>();
		
		for(int i=0;i<capacity;i++){
			if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
				list.addLast(bucket[i]);
				}
		
		return list;
	}

	public Iterable<V> values() {
	
		PositionList<V> list = new NodePositionList<V>();
		
		for(int i=0;i<capacity;i++){
			if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
				list.addLast(bucket[i].getValue());
				}
		
		return list;
	}
	
	public boolean isEmpty() {
		return n==0;
	}

	public int size() {
		return n;
	}
	
	public Iterable<Entry<K,V>>  sameHashEntries(K key){
		
		int hashv = hashValue(key);
		PositionList<Entry<K,V>> list = new NodePositionList<Entry<K,V>>();
		
		
		for(Entry<K,V> e : entries()){
			
			if(hashValue(e.getKey())== hashv)
				
				list.addLast(e);
			}
		
		return list;
	}

	public int clusterSize(K key){
		
		int hashv=hashValue(key);
		int size=0;
		
		for(Entry<K,V> e: entries())
			if(hashv==hashValue(e.getKey()))
				size++;
		
		return size;
	}
	
}