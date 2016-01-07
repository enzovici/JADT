package partition;

import set.Set;


public interface Partition <E> {
	// Restituisce il numero degli insiemi nella
	//partizione
	public int size();
	// Restituisce true se la partizione è vuota
	public boolean isEmpty();
	// Restituisce l'insieme contenente il solo elemento x
	public Set<E> makeSet(E x);
	
	// Restituisce l'unione di A e B, distruggendo
	// i vecchi insiemi A e B
	public Set <E>union(Set<E> A, Set<E> B);
	// restituisce l'insieme che contiene l'elemento x
	public Set <E> find(E x);
	}