package ADT_GraphContainerSD_26_07_2010;

import graph.*;

public interface GraphContainer<V, E> {
	
	boolean isEmpty();
	
	int size();
	
	Graph<V,E> insert();
	
	Vertex<V> insert(Graph<V,E> G, V el);
	
	void insert (Graph<V,E> G, Vertex<V> u, Vertex<V> v, E e);
	
	Iterable<Graph<V,E>> remove();
	
	Iterable<Graph<V,E>> elements();// non necessario ma utile per testare
}
