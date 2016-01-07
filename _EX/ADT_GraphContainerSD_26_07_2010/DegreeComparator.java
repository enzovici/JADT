package ADT_GraphContainerSD_26_07_2010;
import graph.*;

import java.util.Comparator;
import position.*;

public class DegreeComparator<V,E> implements Comparator<Graph<V,E>>{

	public int compare(Graph<V,E> g1, Graph<V,E> g2) {
		AdjacencyListGraph<V, E> grafo1 = (AdjacencyListGraph<V, E>) g1;
		AdjacencyListGraph<V, E> grafo2 = (AdjacencyListGraph<V, E>) g2;
		
		int max1;
		if(((PositionList<Vertex<V>>) grafo1.vertices()).size()>0)
			max1 = grafo1.degree(((PositionList<Vertex<V>>) grafo1.vertices()).first().element());
		else 
			max1 = 0;
		
		int max2;
		if(((PositionList<Vertex<V>>) grafo2.vertices()).size()>0)
			max2 = grafo2.degree(((PositionList<Vertex<V>>) grafo2.vertices()).first().element());
		else 
			max2 = 0;
		
		for(Vertex<V> v : grafo1.vertices())
			if(grafo1.degree(v) > max1)
				max1 = grafo1.degree(v);
		
		for(Vertex<V> v : grafo2.vertices())
			if(grafo2.degree(v) > max2)
				max2 = grafo2.degree(v);
	
		if(max1<max2)
			return -1;
		else if(max1 == max2)
			return 0;
		else
			return 1;
		
	}

}
