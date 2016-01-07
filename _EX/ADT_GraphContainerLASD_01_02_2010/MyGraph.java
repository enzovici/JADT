package ADT_GraphContainerLASD_01_02_2010;

import position.Position;
import graph.*;

public class MyGraph<V,E> extends AdjacencyListGraph<V, E> {

	private Position<Graph<V,E>> location;
	
	
	public MyGraph(){
		super();
		location=null;
	}
	
	public Position<Graph<V,E>> position(){
		return location;
	}
	
	public void setPosition(Position<Graph<V,E>> pos){
		location = pos;
	}
}