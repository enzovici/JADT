package ADT_ArrayGraphSD;

import graph.AdjacencyListGraph;

public class MyGraph<V,E> extends AdjacencyListGraph<V, E> {
	
	private int index;
	
	public MyGraph(){
		super();
		index=-1;
	}
	
	
	public void setIndex(int x){
		index=x;
	}
	
	public int getIndex(){
		return index;
	}
}
