package ADT_GraphContainerSD_26_07_2010;

import graph.*;

public class TEST {
	
	public static void main(String[] args) {
		
		ListGraphContainer<String,String> CT = new ListGraphContainer<String,String>();
		
		Graph<String,String> A = CT.insert();
		Graph<String,String> B = CT.insert();
		Graph<String,String> C = CT.insert();
		Graph<String,String> D = CT.insert();
		
		// C ha grado 1
		Vertex<String> u = CT.insert(C, "c1");
		Vertex<String> v = CT.insert(C, "c2");
		CT.insert(C, "c3");
		CT.insert(C, "c4");
		CT.insert(C, u, v, "e1");
	
		// D ha grado 1
		Vertex<String> z1 = CT.insert(D, "d1");
		Vertex<String> z2 = CT.insert(D, "d2");
		CT.insert(D, "d3");
		CT.insert(D, "d4");
		CT.insert(D, z1, z2, "xz");
		
		
		// B ha grado 2
		Vertex<String> w = CT.insert(B, "b1");
		Vertex<String> z = CT.insert(B, "b2");
		Vertex<String> t = CT.insert(B,"b3");
		Vertex<String> e = CT.insert(B,"b4");
		CT.insert(B, w, z, "e");
		CT.insert(B, w, t, "ee");
		CT.insert(B, z, e,"eee");
		
		// A ha grado 3
		Vertex<String> a = CT.insert(A, "a1");
		Vertex<String> b = CT.insert(A, "a2");
		Vertex<String> c = CT.insert(A, "a3");
		Vertex<String> d = CT.insert(A, "a4");
		CT.insert(A, a, b, "ab");
		CT.insert(A, a, c, "ac");
		CT.insert(A, a, d, "ad");
		CT.insert(A, b, c, "bc");
		CT.insert(A, c, d, "cd");
		
		
		System.out.println(CT.toString());
		
		Iterable<Graph<String,String>> I = CT.remove();
		
	
		for (Graph<String,String> G : I){
			System.out.println();
			for (Vertex<String> x: G.vertices())
				System.out.print(x.element()+" ");
		}
		
		System.out.println("\n\n"+CT.toString());
		
		
	}
	
}
