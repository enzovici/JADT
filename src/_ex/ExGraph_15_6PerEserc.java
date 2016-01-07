package _ex;

import java.util.Iterator;

import map.*;
import arrayList.ArrayIndexList;
import nodeList.NodePositionList;
import nodeList.PositionList;
import graph.AdjacencyListGraph;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graph.BFS;

/*Il programma deve stampare :

Test su un grafo che NON contiene cicli di lunghezza 3 passanti per il vertice 0:
Il grafo contiene i vertici: 0 1 2 3 4 5 6 7 8 
e gli archi: (0,1)(0,2)(0,3)(1,4)(1,5)(1,6)(2,5)(2,6)(3,6)(4,6)(4,7)(4,8)(5,7)(5,8)(6,8)

Se invochiamo removeClosestVertices sul vertice 0 vengono cancellati i vertici:
4 5 6 1 2 3 

Test su un grafo che contiene cicli di lunghezza 3 passanti per il vertice 0:
Il grafo contiene i vertici: 0 1 2 3 4 5 6 7 8 
e gli archi: (0,1)(0,2)(0,3)(0,4)(0,5)(1,4)(1,5)(1,6)(2,5)(2,6)(3,6)(4,6)(4,7)(4,8)(5,7)(5,8)(6,8)

Se invochiamo removeClosestVertices sul vertice 0 vengono cancellati i vertici:
6 1 2 3 7 8 4 5 


*PS: ovviamente i vertici e gli archi potrebbero essere stampati in un diverso ordine
*/


public class ExGraph_15_6PerEserc {
	
	public static void main(String[] args){
		AdjacencyListGraph<Integer,String> G1= new AdjacencyListGraph<Integer,String>();
		AdjacencyListGraph<Integer,String> G2= new AdjacencyListGraph<Integer,String>();
		
	   //I test	
		System.out.println("\n\nTest su un grafo che NON contiene cicli di lunghezza 3 passanti per il vertice 0:");
		System.out.print("Il grafo contiene i vertici: ");
			
		Vertex<Integer>[] A= (Vertex<Integer>[]) new Vertex[9];
		for(int i=0;i<=8;i++)
			A[i]=G1.insertVertex(i);
		
		for(int i= 1;i<4;i++)
			G1.insertEdge(A[0], A[i], null);
	
		for(int i=1;i<=3;i++){
			for(int j= i+3;j<7;j++)
			G1.insertEdge(A[i], A[j], null);
	}
		for(int i=4;i<9;i++){
			for(int j= i+2;j<9;j++)
			G1.insertEdge(A[i], A[j], null);
	}
		
	
   Iterator<Vertex<Integer>> itV=G1.vertices().iterator();
   while(itV.hasNext())
	   System.out.print(itV.next().element()+" ");
   
   System.out.print("\ne gli archi: ");
   Iterator<Edge<String>> itE=G1.edges().iterator();
   while(itE.hasNext()){
	   Edge <String> e= itE.next();
	   System.out.print("("+G1.endVertices(e)[0].element()+","+G1.endVertices(e)[1].element()+")");
   }
   
   
   itV=removeClosestVertices(G1,A[0]).iterator();
   System.out.println("\n\nSe invochiamo removeClosestVertices sul vertice 0 vengono cancellati i vertici:");
   
   while(itV.hasNext())
	   System.out.print(itV.next()+" ");
   
   
   //II test
   System.out.println("\n\nTest su un grafo che contiene cicli di lunghezza 3 passanti per il vertice 0:");
   System.out.print("Il grafo contiene i vertici: ");
		
	for(int i=0;i<=8;i++)
		A[i]=G2.insertVertex(i);
	
	for(int i= 1;i<6;i++)
		G2.insertEdge(A[0], A[i], null);

	for(int i=1;i<=3;i++){
		for(int j= i+3;j<7;j++)
		G2.insertEdge(A[i], A[j], null);
}
	for(int i=4;i<8;i++){
		for(int j= i+2;j<9;j++)
		G2.insertEdge(A[i], A[j], null);
}

	itV=G2.vertices().iterator();
	while(itV.hasNext())
		System.out.print(itV.next().element()+" ");

	System.out.print("\ne gli archi: ");
	itE=G2.edges().iterator();
	while(itE.hasNext()){
		Edge <String> e= itE.next();
		System.out.print("("+G2.endVertices(e)[0].element()+","+G2.endVertices(e)[1].element()+")");
	}


	itV=removeClosestVertices(G2,A[0]).iterator();
	System.out.println("\n\nSe invochiamo removeClosestVertices sul vertice 0 vengono cancellati i vertici:");

	while(itV.hasNext())
		System.out.print(itV.next()+" ");
   
   
   
   }
	
	
  

		//scrivere qui la funzione
		public static<V,E> Iterable<Vertex<V>> removeClosestVertices(Graph<V,E>G,Vertex<V> v){
			
			

			
			NodePositionList<Vertex<V>> L1 = new NodePositionList<Vertex<V>>();//vertici a distanza 1 da v
			NodePositionList<Vertex<V>> L2 = new NodePositionList<Vertex<V>>();//vertici a distanza 2 da v
			NodePositionList<Vertex<V>> output = new NodePositionList<Vertex<V>>();
			
		
			 Iterable<Edge<E>> L1_incidentEdges = G.incidentEdges(v);
			
			 Iterable<Edge<E>> L2_incidentEdges ;
			 
			 for(Edge<E> e : L1_incidentEdges){
				 output.addLast(G.opposite(v, e));
				 L2.addLast(G.opposite(v, e));
				// G.removeVertex(G.opposite(v, e));
				// G.removeEdge(e);
			 }
			 
			for (Vertex<V> vx : L2){
				L2_incidentEdges = G.incidentEdges(vx);
				for (Edge<E> ex : L2_incidentEdges){
					output.addLast(G.opposite(vx, ex));
				//	G.removeVertex(G.opposite(vx, ex));
				//	G.removeEdge(ex);
					
				}
					
				 
			
				
			}
				 
			 

		
			
			
			
			
			
			
	
			return output;  	
		}
	  
}
