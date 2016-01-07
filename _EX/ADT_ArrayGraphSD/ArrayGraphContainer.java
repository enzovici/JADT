package ADT_ArrayGraphSD;

import java.util.Comparator;
import graph.Graph;
import graph.Vertex;
import position.BoundaryViolationException;
import position.NodePositionList;
import position.PositionList;

@SuppressWarnings("all")
public class ArrayGraphContainer<V,E> implements GraphContainer<V, E> {


	private Graph<V,E>[] array;
	private int size;
	private Comparator<Integer> comp;
	
	
	public ArrayGraphContainer(){
		array = (Graph<V,E> []) new Graph[100];
		size=0;
		comp= new DefaultComparator<Integer>();
	}
	
	
	/** crea un nuovo grafo costituito dal solo vertice etichettato con elem e lo inserisce nel contenitore. 
	 *  Restituisce il grafo creato. */
	public Graph<V, E> insert(V elem) {
		
		MyGraph<V, E> grafo = new MyGraph<V, E>();
		grafo.insertVertex(elem);
		
		if(size==0){
			array[size] = grafo;
			size++;
			grafo.setIndex(0);
			return grafo;
		}
		
		for(int i=0 ; i<size ; i++){
		
			if(comp.compare(grafo.numVertices(),array[i].numVertices())<= 0){
				for(int j=size ; j>i ; j--){
					((MyGraph<V,E>)array[j-1]).setIndex(j);
					array[j] = array[j-1];
				}
				array[i] = grafo;
				size++;
				grafo.setIndex(i);
				return grafo;
			}
		}
		array[size]=grafo;
		grafo.setIndex(size);
		size++;
		return grafo;
	}

	/** inserisce un nuovo vertice etichettato con elem nel grafo G. */
	public Vertex<V> insert(Graph<V, E> G, V elem) {
	
		Vertex<V> vertex = G.insertVertex(elem);
		ordinaVerticiGrafo(G);
		
		return vertex;
	}
	
	private void ordinaVerticiGrafo(Graph<V,E> g){
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) g;
		
		if(grafo.getIndex()!=size-1){
				MyGraph<V,E> grafoNext = (MyGraph<V, E>) array[grafo.getIndex()+1];
				while(true){
					if(grafo.numVertices() > grafoNext.numVertices()){
						MyGraph<V,E> temp = (MyGraph<V, E>) array[grafo.getIndex()];
						array[grafo.getIndex()] = array[grafoNext.getIndex()];
						array[grafoNext.getIndex()] = temp;
						((MyGraph<V,E>) array[grafoNext.getIndex()]).setIndex(grafo.getIndex());
						((MyGraph<V,E>) array[grafoNext.getIndex()]).setIndex(grafoNext.getIndex());
					}
					if(grafoNext.getIndex() == (size-1)) 
						return;
					else grafoNext = (MyGraph<V, E>) array[grafoNext.getIndex()+1];
				}
			}
		}


	/** inserisce un nuovo arco etichettato con elem fra i due vertici u e v del grafo G. Lancia un'eccezione nel 
	 *  caso G non sia nel contenitore. */
	public void insert(Graph<V, E> G, Vertex<V> u, Vertex<V> v, E elem) {
	
		MyGraph<V, E> grafo = (MyGraph<V, E>) G;
		if(grafo.getIndex()==-1)
			throw new BoundaryViolationException("Il grafo non è presente nell'array!!");

		grafo.insertEdge(u, v, elem);
	}

	public PositionList<Graph<V, E>> searchAll(int numVertexMax) {
		
		PositionList<Graph<V,E>> lista = new NodePositionList<Graph<V,E>>();
		
		ricercaBinaria(numVertexMax,0,size-1,lista);
		
		return lista;
	}

	/** rimuove dal contenitore il grafo avente il maggior grado massimo. Restituisce il grafo rimosso.*/
	public Graph<V, E> remove1() {
		
		MyGraph<V,E> grafo = (MyGraph<V, E>) array[size-1];
		size--;
		return grafo;
	}

	/** rimuove dal contenitore il grafo in input. */
	public void remove2(Graph<V, E> G) {
		
		MyGraph<V, E> graph = (MyGraph<V, E>) G;
	
		for(int i=graph.getIndex() ; i<size-1 ; i++){
			array[i]=array[i+1];
			((MyGraph<V,E>)array[i]).setIndex(i);
		}
		size--;
	}

	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public String toString(){
	   String stampa ="";
	   for(int i =0;i<size;i++){
		   stampa+="[";
		   for(Vertex<V> v : array[i].vertices()){
			   stampa+=v.element()+" ";
		   }
		   stampa = stampa.substring(0,stampa.length()-1);
		   stampa+="]";
	   
	   }
	   return stampa;
	}

	private void ricercaBinaria(int i,int low,int high,PositionList<Graph<V,E>> lista) {
		
		if(low>high)
			return;
		
		if((high-low)==0){
			if(comp.compare(array[high].numVertices(),i)==0){
				lista.addLast(array[high]);
				return;
			}
		    else
		    	return;
		}
		int middle = (low+high)/2;
		int comparazione = comp.compare(i,array[middle].numVertices());
		
		if(comparazione==0){
			lista.addLast(array[middle]);
				ricercaBinaria(i,low,middle-1, lista);
				ricercaBinaria(i,middle+1,high, lista);
		}
		
		else 
			if(comparazione==1)
				ricercaBinaria(comparazione,middle+1, high, lista);
		
		else
			ricercaBinaria(comparazione,low,middle-1, lista);
	}

}
