package ADT_GraphContainerSD_26_07_2010;

import graph.*;
import position.*;

//NOME: Francesco
//COGNOME: Isernia
//MATRICOLA: 0510201785

public class ListGraphContainer<V, E> implements GraphContainer<V, E>{

	
	private PositionList<Graph<V, E>> lista;
	
	
	public ListGraphContainer(){
		lista =  new NodePositionList<Graph<V,E>>();
	}
	
	public Graph<V, E> insert() {
		
		MyGraph<V, E> grafo = new MyGraph<V, E>();
		lista.addLast(grafo);
		mergeSort(lista);
		return grafo;
	}

	public Vertex<V> insert(Graph<V, E> G, V el) {
		
		MyGraph<V, E> grafo = (MyGraph<V, E>) G;
		Vertex<V> vertice = grafo.insertVertex(el);
		mergeSort(lista);
		return vertice;
	}

	public void insert(Graph<V, E> G, Vertex<V> u, Vertex<V> v, E e) {
		
		MyGraph<V, E> grafo = (MyGraph<V, E>) G;
		if(grafo.position()==null)
			throw new InvalidPositionException("Il grafo non si trova nel contenitore!!!");
		
		grafo.insertEdge(u, v, e);
		mergeSort(lista);
	}

	public Iterable<Graph<V, E>> remove() {
		
		PositionList<Graph<V,E>> list = new NodePositionList<Graph<V,E>>();
		list.addLast(lista.remove(lista.first()));
		MyGraph<V,E> grafo = (MyGraph<V, E>) list.last().element();
		int dg = grafo.maxDegree();
		while(dg == ((MyGraph<V, E>) lista.first().element()).maxDegree())
			list.addLast(lista.remove(lista.first()));
			
		return list;
	}

	public Iterable<Graph<V, E>> elements() {
		return lista;
	}


	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public int size() {

		return lista.size();
	}

	public String toString(){
		String stampa="";
		for(Graph<V, E> g : lista){
			stampa+="[";
			for(Vertex<V> v : g.vertices())
				stampa+=v.element()+" ";
			stampa= stampa.substring(0,stampa.length()-1);
			stampa+="]";
		}
		return stampa;
	}
	
	
	private void mergeSort(PositionList<Graph<V,E>> list){
		
		int size = list.size();
		PositionList<Graph<V, E>> l1 = new NodePositionList<Graph<V,E>>();
		PositionList<Graph<V, E>> l2 = new NodePositionList<Graph<V,E>>();
		
		if(size<2)
			return;
		
		for(int i=0; i<size/2 ; i++)
			l1.addLast(list.remove(list.first()));
		
		for(int i=0; i<size/2 ; i++)
			l2.addLast(list.remove(list.first()));
		
		mergeSort(l1);
		mergeSort(l2);
		merge(l1,l2,list);
	}


	private void merge(PositionList<Graph<V, E>> l1,PositionList<Graph<V, E>> l2, PositionList<Graph<V, E>> list) {
		
		DegreeComparator<V, E> c = new DegreeComparator<V,E>();
		
		while(!l1.isEmpty() && !l2.isEmpty()){
			if(c.compare(l1.first().element(), l2.first().element()) < 0){
				list.addLast(l1.remove(l1.first()));
				((MyGraph<V, E>)list.last().element()).setPosition(list.last());
			}
			else {
				list.addLast(l2.remove(l2.first()));
				((MyGraph<V, E>)list.last().element()).setPosition(list.last());
			}
		}
		
		while(!l1.isEmpty()){
			list.addLast(l1.remove(l1.first()));
			((MyGraph<V, E>)list.last().element()).setPosition(list.last());
		}
		while(!l2.isEmpty()){
			list.addLast(l2.remove(l2.first()));
			((MyGraph<V, E>)list.last().element()).setPosition(list.last());
		}
	}
	
}

