package graph;

import arrayList.ArrayIndexList;
import arrayList.IndexList;
import nodeList.NodePositionList;
import nodeList.PositionList;

public class BFS<V, E, I, R> {
	 protected Graph<V, E> graph;    // The graph being traversed
	 protected Vertex<V> start;      // The start vertex for the DFS
	 protected I info;               // Information object passed to DFS
	 protected R visitResult;        // The result of a recursive traversal call
	 protected static Object STATUS = new Object();    // The status attribute
	 protected static Object VISITED = new Object();   // Visited value
	 protected static Object UNVISITED = new Object(); // Unvisited value
	 protected IndexList<PositionList<Vertex<V>>> layers;

	 public R execute(Graph<V,E> g, Vertex<V> s, I in){
		 graph = g;
		 layers = new ArrayIndexList<PositionList<Vertex<V>>>(graph.numVertices());
		 start = s;
		 info = in;
		 for(Vertex<V> v : graph.vertices()){
			 unVisit(v);
		 }
	 
		 for(Edge<E> e : graph.edges()){
			 unVisit(e);
		 }
		 setup();
		 return finalResult(bfsTrasversal(start));
	 }
	 
	 protected R bfsTrasversal(Vertex<V> v){
		 initResult();
		 if(isDone()){
			 visit(v);
			 layers.add(0,new NodePositionList<Vertex<V>>());
			 layers.get(0).addLast(v);
			 
		 }
		 int i = 0;
		 while(!layers.get(i).isEmpty()){
			 //crea una lista per il livello successivo
			 layers.add(i+1,  new NodePositionList<Vertex<V>>());
			 //scandisce i vertici di livello i
			 for(Vertex<V> vertexInLayer: layers.get(i)){
				 //scandisce gli archi incidenti su vertexInLayer
				 	for(Edge<E> e: graph.incidentEdges(vertexInLayer)){
				 		if(!isVisited(e)){//se l'arco è inesplorato
				 			visit(e);//marca l'arco VISITED
				 			Vertex<V> w = graph.opposite(vertexInLayer, e);
				 			if(!isVisited(w)){//se il vertice w è inesplorato
					 				traverseDiscovery(e,vertexInLayer);
					 				if(isDone())break;
					 				visit(w);
					 				layers.get(i+1).addLast(w); //aggiunge w al livello + 1-esimo
					 				if(isDone())break;
				 			}
				 		}
				 	}//fine for interno
				 	if(isDone())finishVisit(vertexInLayer);
					 
			 } 	//fine primo for (scansione di livello i)
			 
			 
			 i++;
		 }
		 return result();
	 }
	 
	 /** Mark a position (vertex or edge) as visited. */
	 protected void visit(DecorablePosition<?> p) { p.put(STATUS, VISITED); }
	 /** Mark a position (vertex or edge) as unvisited. */
	 protected void unVisit(DecorablePosition<?> p) { p.put(STATUS, UNVISITED); }
	 /** Test if a position (vertex or edge) has been visited. */
	 protected boolean isVisited(DecorablePosition<?> p) {
	   return (p.get(STATUS) == VISITED);
	 }
	 
	 
	 
	 /** Setup method that is called prior to the DFS execution. */
	 protected void setup() {}
	 /** Initializes result (called first, once per vertex visited). */
	 protected void initResult() {}
	 /** Called when we encounter a vertex (v). */
	 protected void startVisit(Vertex<V> v) {}
	 /** Called after we finish the visit for a vertex (v). */
	 protected void finishVisit(Vertex<V> v) {}
	 /** Called when we traverse a discovery edge (e) from a vertex (from). */
	 protected void traverseDiscovery(Edge<E> e, Vertex<V> from) {}
	 /** Called when we traverse a back edge (e) from a vertex (from). */
	 protected void traverseBack(Edge<E> e, Vertex<V> from) {}
	 /** Determines whether the traversal is done early. */
	 protected boolean isDone() { return false; /* default value */ }
	 /** Returns a result of a visit (if needed). */
	 protected R result() { return null; /* default value */ }
	 /** Returns the final result of the DFS execute method. */
	 protected R finalResult(R r) { return r; /* default value */ }
	 

}
