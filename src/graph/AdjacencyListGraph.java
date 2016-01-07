package graph;

import java.util.Iterator;

import map.HashTableMap;
import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;
import exception.InvalidPositionException;

public class AdjacencyListGraph<V, E> implements Graph<V,E> {

	protected  class MyVertex<V> extends MyPosition<V> implements Vertex<V> {
	/** riferimento alla lista di incidenza del vertice */
	protected PositionList<Edge<E>> incEdges;
	/** riferimento alla posizione del vertice nella lista dei vertici. */
	protected Position<Vertex<V>> loc;
	MyVertex(V o) {
	elem = o;
	incEdges = new NodePositionList<Edge<E>>();
	}
	public int degree() {
	return incEdges.size();
	}
	public Iterable<Edge<E>> incidentEdges() {
	return incEdges;
	}

	/** Inserisce un arco nella lista di incidenza. */
	public Position<Edge<E>> insertIncidence(Edge<E> e) {
	incEdges.addLast(e);
	return incEdges.last(); }
	/** Rimuove un arco dalla lista di incidenza. */
	public void removeIncidence(Position<Edge<E>> p)
	{ incEdges.remove(p); }
	public Position<Vertex<V>> location() { return loc; }
	/** Setta la posizione del vertice nella lista dei vertici. */
	public void setLocation(Position<Vertex<V>> p) { loc = p;}
	public String toString() { return elem.toString(); }
	}
	
	
	protected static class MyPosition<T> extends
	HashTableMap<Object,Object> implements DecorablePosition<T> {
	protected T elem;
	public T element() {
	return elem;
	}
	public void setElement(T o) {
	elem = o;
	}
	}
	
	
	
	protected class MyEdge<E> extends MyPosition<E>
	implements Edge<E> {
	/** estremità dell'arco. */
	protected MyVertex<V>[] endVertices;
	/** posizioni relative all'arco nelle liste di incidenza delle
	estremità dell'arco */
	protected Position<Edge<E>>[] Inc;
	/** posizione dellarco nella lista degli archi. */
	protected Position<Edge<E>> loc;
	MyEdge (Vertex<V> v, Vertex<V> w, E o) {
	elem = o;
	endVertices = (MyVertex<V>[]) new MyVertex[2];
	endVertices[0] = (MyVertex<V>)v;
	endVertices[1] = (MyVertex<V>)w;
	Inc = (Position<Edge<E>>[]) new Position[2];
	}
	/** restituisce un array contenente le estremità dellarco */
	public MyVertex<V>[] endVertices() {
	return endVertices;
	}
	public Position<Edge<E>>[] incidences() {
	return Inc;
	}
	public void setIncidences(Position<Edge<E>> pv, Position<Edge<E>> pw) {
	Inc[0] = pv;
	Inc[1] = pw;
	}
	public Position<Edge<E>> location() {
	return loc;
	}
	public void setLocation(Position<Edge<E>> p) {
	loc = p;
	}
	public String toString() {
	return element() + "(" + endVertices[0].toString() +
	"," + endVertices[1].toString() + ")";
	}
	}

	protected NodePositionList<Vertex<V>> VList;
	protected NodePositionList<Edge<E>> EList;
	
	/** costruttore di default: crea un grafo vuoto */
	public AdjacencyListGraph() {
	VList = new NodePositionList<Vertex<V>>();
	EList = new NodePositionList<Edge<E>>();
	}
	
	
	@Override
	public int numVertices() {
		return VList.size();
	}



	@Override
	public int numEdges() {
		return EList.size();
	}



	@Override
	public Iterable<Vertex<V>> vertices() {
		return VList;
	}



	@Override
	public Iterable<Edge<E>> edges() {
		return EList;
	}



	@Override
	public V replace(Vertex<V> p, V o) throws InvalidPositionException {
		V temp = p.element();
		MyVertex<V> vv = checkVertex(p);
		vv.setElement(o);
		return temp;
	}



	@Override
	public E replace(Edge<E> p, E o) throws InvalidPositionException {
		E temp = p.element();
		MyEdge<E> ee = checkEdge(p);
		ee.setElement(o);
		return temp;
	}



	public Iterable<Edge<E>> incidentEdges(Vertex<V> v)
			throws InvalidPositionException {
			MyVertex<V> vv = checkVertex(v);
			return vv.incidentEdges();
			}
			public Vertex<V>[] endVertices(Edge<E> e) throws InvalidPositionException {
			MyEdge<E> ee= checkEdge(e);
			return ee.endVertices();
			}
			public Vertex<V> opposite(Vertex<V> v, Edge<E> e)
			throws InvalidPositionException {
			checkVertex(v);
			MyEdge<E> ee=checkEdge(e);
			Vertex<V>[] endv = ee.endVertices();
			if(v== endv[0])return endv[1];
			else if(v==endv[1])return endv[0];
			else throw new InvalidPositionException("l'arco e non incide su v");
			
			}



	
	
	public String toString(){
		return VList.toString() + "\n" + EList.toString();
		
	}

	@Override
	public E removeEdge(Edge<E> e) throws InvalidPositionException {
		MyEdge<E> ee = checkEdge(e);
		MyVertex<V>[] endv = ee.endVertices();
		Position<Edge<E>>[] inc = ee.incidences();
		endv[0].removeIncidence(inc[0]);
		endv[1].removeIncidence(inc[1]);
		E toReturn = e.element();
		EList.remove(ee.location());
		ee.setLocation(null);
		return toReturn;
	}

	public int degree(Vertex<V> v){
		MyVertex<V> vv = checkVertex(v);
		return vv.degree();
		
	}

	private MyEdge<E> checkEdge(Edge<E> e) {
		if(e == null || !(e instanceof MyEdge))throw new InvalidPositionException("arco non valido");
		return (MyEdge<E>) e;
	}
	
	
	protected MyPosition checkPosition(Position p)
			throws InvalidPositionException {
			if (p == null || !(p instanceof MyPosition))
			throw new InvalidPositionException("posizione non valida");
			return (MyPosition) p;
			}
			protected MyVertex<V> checkVertex(Vertex<V> v)
			throws InvalidPositionException {
			if (v == null || !(v instanceof MyVertex))
			throw new InvalidPositionException("vertice non valido");
			return (MyVertex<V>) v;
			}
		


		
			public Vertex<V> insertVertex(V o) {
				MyVertex<V> vv = new MyVertex<V>(o);
				VList.addLast(vv);
				Position<Vertex<V>> p = VList.last();
				vv.setLocation(p);
				return vv;
				}
				public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E o) throws InvalidPositionException{
					MyVertex<V> vv = checkVertex(v);
					MyVertex<V> uu = checkVertex(u);
					MyEdge<E> newEdge = new MyEdge<E>(vv, uu, o);
					Position<Edge<E>> pV = vv.insertIncidence(newEdge);
					Position<Edge<E>> pU = uu.insertIncidence(newEdge);
					newEdge.setIncidences(pV, pU);
					EList.addLast(newEdge);
					newEdge.setLocation(EList.last());
					return newEdge;
				}
				
				public V removeVertex(Vertex<V> v) throws InvalidPositionException {
					MyVertex<V> temp = checkVertex(v);
					Position<Vertex<V>> toRemove = temp.location();
					V toReturn = VList.remove(toRemove).element();
					return toReturn;
					}
				
		
					public boolean areAdjacent(Vertex<V> u, Vertex<V> v) throws InvalidPositionException {
						Iterator<Edge<E>> it = incidentEdges(u).iterator();
						MyEdge<E> edge;
						while(it.hasNext()) {
							edge = checkEdge(it.next());
							if(edge.endVertices()[0]==v || edge.endVertices()[1]==v)
								return true;
						}
						return false;
						}
	
}
