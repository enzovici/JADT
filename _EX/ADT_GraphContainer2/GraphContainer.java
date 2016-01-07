package ADT_GraphContainer2;

import graph.Graph;
import graph.Vertex;

public interface GraphContainer<V,E> {

	public Graph<V,E> insert();
	
	public Vertex<V> insert(Graph<V,E> G, V elem);
	
	public void insert (Graph<V,E> G, Vertex<V> u, Vertex<V> v, E elem);
	
	public Graph<V,E> remove1();
	
	public Graph<V,E> remove2();
	
	
}

