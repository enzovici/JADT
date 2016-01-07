package dictionary;

import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import entry.MyEntry;
import exception.InvalidEntryException;
import exception.InvalidKeyException;
import entry.Entry;


public class LinearProbingHashTable<K,V> implements Dictionary<K,V>{

public static class HashEntry<K,V> implements Entry<K,V>{
protected K key;
protected V value;

public HashEntry(K k, V v){
key= k;
value = v;
}
public K getKey() {
return key;
}
public V getValue() {
return value;
}

public V setValue(V val) {
V oldValue = value;
value = val;
return oldValue;
}

public boolean equals(Object o) {
HashEntry<K,V> ent;
try { 
ent = (HashEntry<K,V>) o; 
}catch (ClassCastException ex) { 
return false; 
}
return (ent.getKey() == key) && (ent.getValue() == value);
}

public String toString(){
return "(" + key + "," + value +")";
}

}
protected Entry<K,V> AVAILABLE = new HashEntry<K,V> (null, null); // marker 
protected int n = 0; // number of entries in the dictionary
protected int capacity;	// capacity of the bucket array
protected Entry<K,V>[] bucket;	// array di singole Entry
protected int scale, shift; // the shift and scaling factors

public LinearProbingHashTable(int capacity){
this.capacity = capacity;
bucket = (Entry<K,V>[]) new Entry[capacity];

java.util.Random rand = new java.util.Random();
scale = rand.nextInt(capacity - 1) + 1;
shift = rand.nextInt(capacity);
}

public LinearProbingHashTable(){
this(1024);
}

public MyEntry<K,V> checkEntry(Entry<K,V> e) throws InvalidEntryException{
if((e==null) || (e instanceof MyEntry)) throw new InvalidEntryException("entry non valida");
return (MyEntry<K,V>)e;
}

protected void checkKey(K k) {
if (k == null) 
throw new InvalidKeyException("Invalid key: null.");
}

/** Funzione has che applica il metodo MAD al valore ottenuto applicato */
public int hashValue(K key) {
return Math.abs(key.hashCode()*scale + shift) % capacity;
}

public int size() {
return n;
}


public boolean isEmpty() {
return (n==0);
}


public Entry<K, V> find(K key) throws InvalidKeyException {
checkKey(key);
int i = hashValue(key);
int j = i;
do{
	Entry<K,V> e = bucket[i];
	if (e == null)	//se la chiave non è presente
	break;
	if(key.equals(e.getKey()))
	return e;
	i= (i+1) % capacity;
}while(i != j);
return null;	
}


public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
checkKey(key);
PositionList<Entry<K,V>> l = new NodePositionList<Entry<K,V>>();
int i = hashValue(key);
int j=i;
do{
	Entry<K,V> entry = bucket[i];
	if(entry == null) break;
	if(key.equals(entry.getKey())) l.addLast(entry);
	i = (i+1) % capacity;
}while(i != j);
return l;
}

public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
checkKey(key);
if(capacity<= 2*size())	//load factor >= 0.5
rehash();

int i = hashValue(key);
int j = i;

do{
Entry<K,V> e = bucket[i];
if( e == null || e == AVAILABLE){
bucket[i] = new HashEntry<K,V>(key,value);
n++;
break;
}
i = (i+1) % capacity;
}while( i != j);
return bucket[i];
}

protected void rehash(){
capacity = 2*capacity;
Entry<K,V>[] old = bucket;
bucket = (Entry<K,V>[]) new Entry[capacity];

java.util.Random rand = new java.util.Random();
scale = rand.nextInt(capacity - 1) + 1;
shift = rand.nextInt(capacity);

for(int i = 0; i<old.length; i++){
Entry<K,V> e = old[i];
if((e != null) && (e != AVAILABLE)){
int insIndex = -findEntry(e) -1;
bucket[insIndex] = e;
}
}
}

public int findEntry(Entry<K,V> ent) throws InvalidKeyException{
checkEntry(ent);

int avail = capacity;
K eKey = ent.getKey();
int i = hashValue(eKey);
int j = i;
do{
Entry<K,V> e = bucket[i];
if ( e == null){
if(avail == capacity)
avail = i;
break;
}
if (ent == e) return i;
if (e == AVAILABLE){
if(avail == capacity)
avail = i;
}
i = (i+1) % capacity;
}while(i!=j);
return -(avail-1);
}

public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
checkEntry(e);
int i = hashValue(e.getKey());
int j = i;
do{
Entry<K,V> ent = bucket[i];
if(ent == null) break;
if(e.equals(ent)){
n--;
bucket[i] = AVAILABLE;
return ent;
}
i = (i+1) % capacity;
}while (i != j);
return null;
}

public Entry<K, V> removeOld(Entry<K, V> e) throws InvalidEntryException{
int i= findEntry(e);
if(i<0)
return null;
Entry<K,V> toReturn=bucket[i];
bucket[i]=AVAILABLE;
n--;
return toReturn;
}

public Iterable<Entry<K, V>> entries() {
PositionList<Entry<K,V>> entries = new NodePositionList<Entry<K,V>>();
for(int i=0; i<capacity; i++){
if((bucket[i] != null) && ( bucket[i] != AVAILABLE))
entries.addLast(bucket[i]);
}
return entries;
}
}