package ADT_GraphContainer2;

import position.*;
import graph.*;

public class ListGraphContainer<V,E> implements GraphContainer<V, E> {

	private PositionList<Graph<V,E>> listaVertex;
	private PositionList<Graph<V,E>> listaEdge;
	
	public ListGraphContainer(){
		listaVertex = new NodePositionList<Graph<V,E>>();
		listaEdge = new NodePositionList<Graph<V,E>>();
	}
	

	public Graph<V, E> insert() {
		
		MyGraph<V, E> grafo = new MyGraph<V, E>();
		
		listaVertex.addFirst(grafo);
		listaEdge.addFirst(grafo);
		grafo.setPositionVertex(listaVertex.first());
		grafo.setPositionEdge(listaEdge.first());
		
		return grafo;
	}


	public void ordinaListaVertici(Graph<V,E>  G){
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		
		for(Position<Graph<V,E>> pg : listaVertex.positions())
			if(G.numVertices() <= pg.element().numVertices() ){
				listaVertex.addBefore(pg,G);
				grafo.setPositionVertex(listaVertex.prev(pg));
			return;
			}
		 
		listaVertex.addLast(G);
		grafo.setPositionVertex(listaVertex.last());
	}

	public void ordinaListaArchi(Graph<V,E> G){

		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		
		for(Position<Graph<V,E>> pg : listaEdge.positions())
			if(G.numEdges() <= pg.element().numEdges() ){
				listaEdge.addBefore(pg,G);
				grafo.setPositionEdge(listaEdge.prev(pg));
			return; 
			}
		
		listaEdge.addLast(G);
		grafo.setPositionEdge(listaEdge.last());
	}
	
	public Vertex<V> insert(Graph<V, E> G, V elem) {
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		Vertex<V> v = G.insertVertex(elem);
		
		listaVertex.remove(grafo.positionVertex());
		listaEdge.remove(grafo.positionEdge());
		
		ordinaListaVertici(G);
		ordinaListaArchi(G);
		
		return v;

	}

	public void insert(Graph<V, E> G, Vertex<V> u, Vertex<V> v, E elem)throws InvalidPositionException{
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) G;
		
		if(grafo.positionEdge()==null || grafo.positionVertex()==null) 
			throw new InvalidPositionException("La posizione del grafo passato in input al metodo non esiste!!");
		
		listaEdge.remove(grafo.positionEdge());
		G.insertEdge(u, v, elem);
		ordinaListaArchi(grafo);
	}


	public Graph<V, E> remove1() {
	
		MyGraph<V, E> grafo = (MyGraph<V, E>) listaVertex.last().element();
		
		listaVertex.remove(grafo.positionVertex());
		listaEdge.remove(grafo.positionEdge());
		
		return grafo;
	}


	public Graph<V, E> remove2() {

		MyGraph<V,E> grafo = (MyGraph<V, E>) listaEdge.last().element();
		
		listaVertex.remove(grafo.positionVertex());
		listaEdge.remove(grafo.positionEdge());
		
		return grafo;
	}
	
	public boolean isEmpty(){
		return listaVertex.isEmpty();
	}
	
	public int size(){
		return listaVertex.size();
	}
	
	public PositionList<Graph<V,E>> positionVertex(){
		return listaVertex;
	}
	
	
}
