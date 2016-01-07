package graph;

public interface DirectedGraph<V, E> extends
Graph<V,E>{
public boolean isDirected(Edge<E> e);
public void insertDirectedEdge(Vertex<V> u, Vertex<V>v,V o);
}