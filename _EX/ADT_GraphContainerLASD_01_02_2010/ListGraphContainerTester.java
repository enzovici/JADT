package ADT_GraphContainerLASD_01_02_2010;

import graph.Graph;
import graph.Vertex;

public class ListGraphContainerTester {
@SuppressWarnings("all")
	public static void main(String[] args) {
	
		ListGraphContainer<Integer, Integer> lista = new ListGraphContainer<Integer, Integer>();
		
		Graph<Integer,Integer> g1 = lista.insert(3);
		Graph<Integer,Integer> g2 = lista.insert(4);
		Graph<Integer,Integer> g3 = lista.insert(3);
		Graph<Integer,Integer> g4 = lista.insert(111);
		
		Vertex<Integer> v1g1 = lista.insert(g1,1);
		Vertex<Integer> v2g1 = lista.insert(g1,2);
		Vertex<Integer> v3g1 = lista.insert(g1,3);
		
		Vertex<Integer> v1g2 = lista.insert(g2,4);
		Vertex<Integer> v2g2 = lista.insert(g2,6);
		Vertex<Integer> v3g2 = lista.insert(g2,88);
		Vertex<Integer> v4g2 = lista.insert(g2,12);
		
		Vertex<Integer> v1g3 = lista.insert(g3,01);
		Vertex<Integer> v2g3 = lista.insert(g3,11);
		Vertex<Integer> v3g3 = lista.insert(g3,21);
		
		
		lista.insert(g1,v1g1,v2g1,12);
		lista.insert(g1,v3g1,v1g1,111);
		lista.insert(g1,v3g1,v2g1,12);
		
		lista.insert(g2,v1g2,v2g2,125);
		lista.insert(g2,v1g2,v3g2,132);
		lista.insert(g2,v3g2,v4g2,112);
		lista.insert(g2,v4g2,v2g2,122);
		
		lista.insert(g3,v1g3,v2g3,12);
		lista.insert(g1,v2g3,v3g3,12);
		lista.insert(g1,v1g3,v3g3,12);
		
		
		
		System.out.println("Grafi contenuti nel contenitore:\n"+lista.toString());
		
		/** Rimuove il grafo con numero di vertici maximo dalla lista */
		lista.remove1();
		System.out.println("Grafi contenuti nel contenitore dopo la rimozione del grafo con numero di vertici maggiore:\n"+lista.toString());
		
		/** Rimuove il grafo g2 dalla lista */
		lista.remove2(g3);
		System.out.println("Grafi contenuti nel contenitore dopo la rimozione del grafo g1:\n"+lista.toString());
		
		/** Stampa la quantità dei grafi contenuti nel contenitore */
		System.out.println("Quantità del contenitore di grafi dopo 2 rimozioni precedenti:\n"+lista.size());
		
		/** Verifica se il contenitore di grafi è vuoto. */
		System.out.println("Il contenitore di grafi è vuoto ?:\n"+lista.isEmpty());
	
		
		
	
	
		
		
		
		
	}

}
