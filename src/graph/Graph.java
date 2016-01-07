package graph;

import exception.InvalidPositionException;

public interface Graph<V, E> {
	
public int numVertices();
public int numEdges();
public Iterable<Vertex<V>> vertices();
public Iterable<Edge<E>> edges();
public V replace(Vertex<V> p, V o) throws
InvalidPositionException;
public E replace(Edge<E> p, E o) throws
InvalidPositionException;
public Iterable<Edge<E>> incidentEdges(Vertex<V> v)throws
InvalidPositionException;

public Vertex[] endVertices(Edge<E> e) throws
InvalidPositionException;
public Vertex<V> opposite(Vertex<V> v, Edge<E> e)
throws InvalidPositionException;
public boolean areAdjacent(Vertex<V> u, Vertex<V> v)
throws InvalidPositionException;
public Vertex<V> insertVertex(V o);
public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E o)
throws InvalidPositionException;
public V removeVertex(Vertex<V> v) throws InvalidPositionException;
public E removeEdge(Edge<E> e) throws InvalidPositionException;

}