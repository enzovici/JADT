package ADT_GraphContainerSD_26_07_2010;

import graph.*;
import position.*;

public class MyGraph<V,E> extends AdjacencyListGraph<V, E>{

	private Position<Graph<V,E>> loc;
	
	public MyGraph(){
		super();
		loc = null;
	}
	
	public Position<Graph<V, E>> position() { 
		return loc; 
	}
	
	public void setPosition(Position<Graph<V, E>> g) { 
		loc = g; 
	}
	
	public int maxDegree(){
		int dg;
		if(((PositionList<Vertex<V>>) vertices()).size()>0)
			dg = degree(((PositionList<Vertex<V>>) vertices()).first().element());
		else 
			dg = 0;
		
		for(Vertex<V> v : vertices())
			if(degree(v) > dg)
				dg = degree(v);
		
		return dg;
	}
}
