package ADT_GraphContainer2;

import graph.Graph;
import graph.Vertex;

public class ListGraphContainerTester {

	
	public static void main(String[] args) {
	
		ListGraphContainer<Integer, Integer> lista = new ListGraphContainer<Integer, Integer>();
		
		Graph<Integer,Integer> g1 = lista.insert();
		Graph<Integer,Integer> g2 = lista.insert();
		Graph<Integer,Integer> g3 = lista.insert();
		
		
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
		
		System.out.println(lista.size());
		
		String stampa ="";
		for(Graph<Integer,Integer> pg : lista.positionVertex()){
			stampa="(";
			for(Vertex<Integer> v : pg.vertices())
				stampa+=v.element()+"-";
				
			stampa=(String) stampa.substring(0,stampa.length()-1);
			stampa+=")";
			System.out.print(stampa);
		}
		
		
		
		System.out.println();
		lista.remove1();
		System.out.println(lista.size());
		
	
		stampa="";
		for(Graph<Integer,Integer> pg : lista.positionVertex()){
			stampa="(";
			for(Vertex<Integer> v : pg.vertices())
				stampa+=v.element()+"-";
				
			stampa=(String) stampa.substring(0,stampa.length()-1);
			stampa+=")";
			System.out.print(stampa);
		}
		
		
		
		/** Verifica se il contenitore di grafi è vuoto. */
		System.out.println("\n\nIl contenitore di grafi è vuoto ?:\n"+lista.isEmpty());
		
		
		System.out.println();
		lista.remove2();
		System.out.println(lista.size());
		
	
		stampa="";
		for(Graph<Integer,Integer> pg : lista.positionVertex()){
			stampa="(";
			for(Vertex<Integer> v : pg.vertices())
				stampa+=v.element()+"-";
				
			stampa=(String) stampa.substring(0,stampa.length()-1);
			stampa+=")";
			System.out.print(stampa);
		}
		
		
		
		/** Verifica se il contenitore di grafi è vuoto. */
		System.out.println("\n\nIl contenitore di grafi è vuoto ?:\n"+lista.isEmpty());
	

		
		
	
	
	}

}
