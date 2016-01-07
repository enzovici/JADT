package ADT_TreeContainerLASD_13_01_2010;

import tree.Tree;

public class ListTreeContainerTester {

	public static void main(String...strings){
		
		
		ListTreeContainer<Integer> lista = new ListTreeContainer<Integer>();
		
		Tree<Integer> a1 = lista.insert(1);
		Tree<Integer> a2 = lista.insert(2);
		Tree<Integer> a3 = lista.insert(22);
		Tree<Integer> a4 = lista.insert(345);
		
		lista.insertChild(a1,a1.root(),2);
		lista.insertChild(a1,a1.root(),11);
		lista.insertChild(a1,a1.root(),23);
		lista.insertChild(a1,a1.root(),20);
		lista.insertChild(a1,a1.root(),8);
		lista.insertChild(a1,a1.root(),43);
		lista.insertChild(a1,a1.root(),887);
		
		
		lista.insertChild(a2,a2.root(),212);
		lista.insertChild(a2,a2.root(),17);
		lista.insertChild(a2,a2.root(),13);
	    lista.insertChild(a2,a2.root(),55);
		
		lista.insertChild(a3,a3.root(),10);
		lista.insertChild(a3,a3.root(),18);
		lista.insertChild(a3,a3.root(),99);
		
		lista.insertChild(a4,a4.root(),77);
		lista.insertChild(a4,a4.root(),44);
		lista.insertChild(a4,a4.root(),33);
		lista.insertChild(a4,a4.root(),22);
		lista.insertChild(a4,a4.root(),11);
		
		System.out.println("Alberi inseriti nella lista:\n"+lista.toString());
		System.out.println("Quantità di alberi : "+lista.size());
		
		lista.remove();
		
		System.out.println("Quantità di alberi dopo la rimozione: "+lista.size());
		System.out.println("Alberi inseriti nella lista:\n"+lista.toString());	
		System.out.println("La lista di alberi è vuota ? "+lista.isEmpty());
	
	}
	
	
	
	
	
}
