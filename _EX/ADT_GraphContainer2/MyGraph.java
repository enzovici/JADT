package ADT_GraphContainer2;

import graph.AdjacencyListGraph;
import graph.Graph;
import position.Position;

public class MyGraph<V,E> extends AdjacencyListGraph<V,E> implements GraphPosition<V,E> {

	private Position<Graph<V,E>> posV;
	private Position<Graph<V,E>> posE;
	
	public MyGraph(){
		super();
		posV=null;
		posE=null;
		
	}
	
	
	public E element() {
		return null;
	}


	public Position<Graph<V, E>> positionEdge() {
		return posE;
	}


	public Position<Graph<V, E>> positionVertex() {
		return posV;
	}


	public void setPositionEdge(Position<Graph<V, E>> g) {
		posE = g;
	}


	public void setPositionVertex(Position<Graph<V, E>> g) {
		posV = g;
	}

}
