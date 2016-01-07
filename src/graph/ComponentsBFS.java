package graph;


/** This class extends BFS to compute the connected components of a graph. */
public class ComponentsBFS<V, E> extends BFS<V, E, Object, Integer> {
  protected Integer compNumber; // Connected component number
  protected Object COMPONENT = new Object(); // Connected comp. selector
  protected void setup() { compNumber = 1; }
  protected void startVisit(Vertex<V> v) { v.put(COMPONENT, compNumber);}
  
  protected Integer finalResult(Integer bfsResult) { 
    for (Vertex<V> v : graph.vertices()) // check for any unvisited vertices
      if (v.get(STATUS) == UNVISITED) { 
        compNumber += 1;  // we have found another connected component
	bfsTrasversal(v);  // visit all the vertices of this component
      }
    return compNumber;
  }
}