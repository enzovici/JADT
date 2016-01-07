package ADT_GraphContainer2;

import graph.Graph;
import position.Position;


public interface GraphPosition<V,E> extends Position<E> {

	public void setPositionVertex(Position<Graph<V,E>> g); 
	
	public void setPositionEdge(Position<Graph<V,E>> g); 
	
	public Position<Graph<V,E>> positionVertex(); 
	
	public Position<Graph<V,E>> positionEdge();
}
