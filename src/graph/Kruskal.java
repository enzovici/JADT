package graph;

import entry.Entry;
import partition.ListPartition;
import partition.Partition;
import comparator.DefaultComparator;
import priorityQueue.HeapPriorityQueue;
import priorityQueue.PriorityQueue;
import nodeList.NodePositionList;
import nodeList.PositionList;

public class Kruskal<V, E> {
	
	protected Graph<V,E> graph;
	protected Object WEIGHT; // peso di un arco
	protected PositionList<Edge<E>> Elist;
	
	protected PriorityQueue<Double, Edge<E>> Q; //per esaminare gli archi in ordine di peso
	
	public Iterable<Edge<E>> execute(Graph<V,E> g, Object w){
		graph = g;
		WEIGHT = w;
		
		DefaultComparator dc = new DefaultComparator();
		
		Q =  new HeapPriorityQueue<Double, Edge<E>>(dc);
		Elist = new NodePositionList<Edge<E>>();
		kruskalAlg(Elist);
		return Elist;
	}
	
	
	protected void kruskalAlg(PositionList<Edge<E>> EList){
		Partition<Vertex<V>> P = new ListPartition<Vertex<V>>();
	
	//inserisce ciascun vertice in un insieme della partizione
	for(Vertex<V> w : graph.vertices() ){
		P.makeSet(w);
	}
	
	for(Edge<E> e : graph.edges()){
		Q.insert((Double)e.get(WEIGHT), e);
	}
	
	
	while(Elist.size() < graph.numVertices() -1){
		Entry<Double,Edge<E>> e_entry = Q.removeMin();
		Edge<E> e = e_entry.getValue();
		Vertex<V> endV[] = graph.endVertices(e);
		Vertex<V> u = endV[0];
		Vertex<V> v = endV[1];
		
		if(P.find(u)!= P.find(v)){
			P.union(P.find(u), P.find(v));
			Elist.addLast(e);
		}
	}
	
	
		
	}




}