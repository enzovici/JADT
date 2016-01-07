package ADT_GraphContainerLASD_01_02_2010;

import graph.*;

public interface GraphContainer<V,E> {
	
	/** crea un nuovo grafo costituito dal solo vertice etichettato con elem e lo inserisce nel contenitore. 
	 *  Restituisce il grafo creato. */
	public Graph<V,E> insert(V elem);
	
	/** inserisce un nuovo vertice etichettato con elem nel grafo G. */
	public Vertex<V> insert(Graph<V,E> G, V elem);
	
	/** inserisce un nuovo arco etichettato con elem fra i due vertici u e v del grafo G. Lancia un'eccezione nel 
	 *  caso G non sia nel contenitore. */
	public void insert (Graph<V,E> G, Vertex<V> u, Vertex<V> v, E elem);
	
	/** rimuove dal contenitore il grafo avente il maggior grado massimo. Restituisce il grafo rimosso.*/
	public Graph<V,E> remove1();
	
	/** rimuove dal contenitore il grafo in input. */
	public void remove2(Graph<V,E> G);

}
