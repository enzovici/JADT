package ADT_GraphContainerLASD_01_02_2010;

import position.*;
import graph.Graph;
import graph.Vertex;

public class ListGraphContainer<V,E> implements GraphContainer<V, E> {

	private NodePositionList<Graph<V,E>> lista;
	
	
	public ListGraphContainer(){
		lista = new NodePositionList<Graph<V,E>>();
	}
	
	/** crea un nuovo grafo costituito dal solo vertice etichettato con elem e lo inserisce nel contenitore. 
	 *  Restituisce il grafo creato. */
	public Graph<V, E> insert(V elem) {
		
		MyGraph<V, E> grafo = new MyGraph<V, E>();
		grafo.insertVertex(elem);
		ordinaLista(grafo);
		
		return grafo;
	}

	/** inserisce un nuovo vertice etichettato con elem nel grafo G. */
	public Vertex<V> insert(Graph<V, E> G, V elem) {
		
		Vertex<V> vert = G.insertVertex(elem);
		aggiornaLista(G);
		return vert;
	}

	/** inserisce un nuovo arco etichettato con elem fra i due vertici u e v del grafo G. Lancia un'eccezione nel 
	 *  caso G non sia nel contenitore. */
	public void insert(Graph<V, E> G, Vertex<V> u, Vertex<V> v, E elem) {
		
		MyGraph<V,E> g = (MyGraph<V, E>) G;
		if(g.position()==null)
			throw new InvalidPositionException("Il grafo non è nel contenitore!");
		
		g.insertEdge(u, v, elem);
	}

	/** rimuove dal contenitore il grafo avente il maggior grado massimo. Restituisce il grafo rimosso.*/
	public Graph<V, E> remove1() {
		
		Graph<V,E> grafoRimosso = lista.remove(lista.last());
		return grafoRimosso;
	}

	/** rimuove dal contenitore il grafo in input. */
	public void remove2(Graph<V, E> G) {
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		lista.remove(grafo.position());
	}
	
	public int size(){
		return lista.size();
	}
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
	public String toString(){
		String stampa="";
		
		for(Graph<V,E> g : lista){
			stampa+="(";
			for( Vertex<V> v : g.vertices())
				stampa+= v.element()+" ";
			
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+=")";
			
		}
		
		return stampa;
	}

	private void ordinaLista(Graph<V,E> G){
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		
		for(Position<Graph<V,E>> g : lista.positions())
				if(G.numVertices()<=g.element().numVertices()){
					lista.addBefore(g, G);
					grafo.setPosition(lista.prev(g));
					return;
				}
		lista.addLast(G);
		grafo.setPosition(lista.last());
	}
	
	private void aggiornaLista(Graph<V,E> G){
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		
		if(grafo.position()!=lista.last()){
			Position<Graph<V, E>> n = lista.next(grafo.position());
			
			while(true){
				if(grafo.numVertices()>n.element().numVertices())
					lista.swapElement(grafo.position(), n);
				
				if(n == lista.last()) 
					return;
				
				else n = lista.next(n);
			}
		}
	}
}
