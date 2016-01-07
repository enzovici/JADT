package set;

public interface Set<E> {
	// Restituisce il numero degli elementi nell'insieme
	public int size();
	// Restituisce true se l'insieme è vuoto
	public boolean isEmpty();
	// Rimpiazza this con l'unione di this e B
	public Set<E> union(Set<E> B);
	// Rimpiazza this con l'intersezione di this e B
	public Set<E> intersect(Set<E> B);
	// Rimpiazza this con la differenza di this e B
	public Set <E>subtract(Set <E> B);
	
	}