package ADT_ArrayGraphSD;

import position.PositionList;
import graph.Graph;
import graph.Vertex;

public class ArrayGraphTester {
@SuppressWarnings("all")
	public static void main(String[] args) {

		ArrayGraphContainer<Integer,Integer> array = new ArrayGraphContainer<Integer, Integer>();
		
		
		Graph<Integer,Integer> g1 = array.insert(3);
		Vertex<Integer> v1g1 = array.insert(g1,1);
		Vertex<Integer> v2g1 = array.insert(g1,2);
		Vertex<Integer> v3g1 = array.insert(g1,3);
	
		array.insert(g1,v1g1,v2g1,12);
		array.insert(g1,v3g1,v1g1,111);
		array.insert(g1,v3g1,v2g1,12);
	
		Graph<Integer,Integer> g2 = array.insert(4);
		Vertex<Integer> v1g2 = array.insert(g2,4);
		Vertex<Integer> v2g2 = array.insert(g2,6);
		Vertex<Integer> v3g2 = array.insert(g2,88);
		Vertex<Integer> v4g2 = array.insert(g2,12);
	
		array.insert(g2,v1g2,v2g2,125);
		array.insert(g2,v1g2,v3g2,132);
		array.insert(g2,v3g2,v4g2,112);
		array.insert(g2,v4g2,v2g2,122);
		
		Graph<Integer,Integer> g3 = array.insert(3);
		Vertex<Integer> v1g3 = array.insert(g3,1);
		Vertex<Integer> v2g3 = array.insert(g3,11);
		Vertex<Integer> v3g3 = array.insert(g3,21);

		array.insert(g3,v1g3,v2g3,12);
		array.insert(g1,v2g3,v3g3,12);
		array.insert(g1,v1g3,v3g3,12);
		
		
		
		Graph<Integer,Integer> g4 = array.insert(10);
		Graph<Integer,Integer> g5 = array.insert(11);
		Graph<Integer,Integer> g6 = array.insert(12);
		
		
		
		
		
		
		System.out.println("Grafi contenuti nel contenitore:\n"+array.toString());
		System.out.println("Grafi contenuti nel contenitore:\n"+array.size());
		
		PositionList<Graph<Integer,Integer>> lista = array.searchAll(1);
		
		String stampa="";
		for(Graph<Integer,Integer> g : lista){
			stampa+="[";
			for(Vertex<Integer> v : g.vertices())
				stampa+=v.element()+" ";
			
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="]";
		}
		System.out.println("\nI nodi che hanno un solo sono vertice sono: "+stampa);
	
		array.remove1();
		System.out.println("Grafi contenuti nel contenitore:\n"+array.toString());
		System.out.println("Grafi contenuti nel contenitore:\n"+array.size());
		
		array.remove2(g6);
		
		System.out.println("Grafi contenuti nel contenitore:\n"+array.toString());
		System.out.println("Grafi contenuti nel contenitore:\n"+array.size());
		
	}

}
