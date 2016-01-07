package priorityQueue;

import java.util.Comparator;

import comparator.DefaultComparator;
import completBinaryTree.ArrayListCompleteBinaryTree;
import completBinaryTree.CompleteBinaryTree;
import entry.Entry;
import exception.EmptyPriorityQueueException;
import exception.InvalidKeyException;
import position.Position;
import entry.MyEntry;

public class HeapPriorityQueue<K,V> implements PriorityQueue<K,V> {

	protected CompleteBinaryTree<Entry<K,V>> heap;
	protected Comparator<K> comp;
	
	
	protected static class MyEntry<K,V> implements 
	Entry<K,V> { 
	 protected K key; protected V value; 
	 public MyEntry(K k, V v) { key = k; value = v; } 
	 public K getKey() { return key; } 
	 public V getValue() { return value; } 
	 public String toString() { return "(" + key + "," + 
	value + ")"; } 
	}
	
	
	
	//esercizio:
	
// Aggiungere alla classe HeapPriorityQueue il 
//	costruttore (da includere nel progetto) 
//	 HeapPriorityQueue(K k[] , V v[], Comparator<K> C) 
//	 che costruisce una coda a priorità con entrate in 
//	tempo lineare
//	
	
	 /** Crea un HeapPriorityQueue dato un array di n elementi  */		
	public HeapPriorityQueue(K[] k, V[] v, Comparator<K> c){
		this(c);
		
		Position<Entry<K,V>>[] entries = (Position<Entry<K,V>>[]) new Position[k.length + 1];
		for(int i = 0;i < k.length; i++){
			entries[i+1] = heap.add(new MyEntry<K,V>(k[i],v[i]));
		}
		
		for(int i = size() /2; i > 0; i--){
			downHeap(entries[i]);
		}
		
	}


	
	
	
	public HeapPriorityQueue(Comparator<K> c){
		heap=new ArrayListCompleteBinaryTree<Entry<K,V>>();
		comp=new DefaultComparator<K>();
		
	}
	
	protected boolean checkKey(K key) throws InvalidKeyException {
		boolean result;
		
		try { // controlla se la chiave può essere confrontata con sé stessa
			result = (comp.compare(key,key)==0);
		} 
		catch (ClassCastException e) {
			throw new InvalidKeyException("la chiave non è confrontabile"); 
			}
		
		return result;
	}
	
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		checkKey(key);
		Entry<K,V> entry = new MyEntry<K, V>(key, value);
		upHeap(heap.add(entry));
		
		return entry;
	}

	
	protected void upHeap(Position<Entry<K,V>> v){
		Position<Entry<K,V>> u;
		while(!heap.isRoot(v)){
			u=heap.parent(v);
				if(comp.compare(u.element().getKey(), v.element().getKey())<=0)
					break;
				swap(u,v);
				v=u;
		}
	}
	
	public void swap(Position<Entry<K, V>> x, Position<Entry<K, V>> y) {
		Entry<K,V> temp = x.element();
		
		heap.replace(x, y.element());
		heap.replace(y, temp);
		
	}

	public boolean isEmpty() {
	return heap.isEmpty();
	}

	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if(isEmpty()) throw new EmptyPriorityQueueException("La coda a priorità è vuota");
		return heap.root().element();
	}

	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(isEmpty()) throw new EmptyPriorityQueueException("Coda a priorità piena!!!");
		Entry<K,V> min=heap.root().element();
		if(size()==1)
			heap.remove();
		
		else {
			heap.replace(heap.root(), heap.remove());
			downHeap(heap.root());
		}
		
		return min;
	}

	public void downHeap(Position<Entry<K, V>> root) {
		while(heap.isInternal(root)){
			
			Position<Entry<K,V>> s;
			
			if(!heap.hasRight(root))
				s=heap.left(root);
			
			else if(comp.compare(heap.left(root).element().getKey(),heap.right(root).element().getKey())<=0)
					s=heap.left(root);
				
			else
				s=heap.right(root);
				
				if(comp.compare(s.element().getKey(),root.element().getKey())<0){
					swap(root,s);
					root=s;
				}
				else break;
		}
	}

	public int size() {
		return heap.size();
	}

}
