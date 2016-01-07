package ADT_SetContainer;

import position.NodePositionList;
import position.PositionList;
import set.Set;

public class ListSetContainerTester {

	public static void main(String[] args) {

		
		PositionList<Integer> l1 = new NodePositionList<Integer>();
		
		l1.addLast(12);
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(4);
		l1.addLast(7);
		l1.addLast(9);
		l1.addLast(8);
		
		
		PositionList<Integer> l2 = new NodePositionList<Integer>();
		
		l2.addLast(12);
		l2.addLast(1);
		l2.addLast(2);
		l2.addLast(4);
		
		
		PositionList<Integer> l3 = new NodePositionList<Integer>();
		
		l3.addLast(22);
		l3.addLast(10);
		l3.addLast(43);
		l3.addLast(73);
		l3.addLast(19);
		l3.addLast(28);
		l3.addLast(17);
		
		
		PositionList<Integer> l4 = new NodePositionList<Integer>();
		
		l4.addLast(10);
		l4.addLast(13);
		l4.addLast(17);
		l4.addLast(19);
		l4.addLast(18);
		
		
		
		ListSetContainer<Integer> lista = new ListSetContainer<Integer>();
		
		Set<Integer> s1 =lista.insert(l1, l2);
		Set<Integer> s2=lista.insert(l3, l4);
		
		System.out.println("Elementi contenuti nel primo insieme: ");
		for(Integer el : s1.elements())
			System.out.print(el+" ");
		
		System.out.println("\n\nElementi contenuti nel secondo insieme: ");
		for(Integer el : s2.elements())
			System.out.print(el+" ");
		
		
	/*	System.out.println("\nInsieme con numero maggiore di elementi che viene rimosso: ");
		PositionList<Integer> listaElementiRimossi = (PositionList<Integer>) lista.remove();
		for(Integer el : listaElementiRimossi)
			System.out.print(el+" ");
	*/		
		
		System.out.println("\n\nInsieme che elimina gli elementi doppioni tra i vari insiemi unendoli in un unico insieme: ");
		PositionList<Integer> listaElementiDoppioni = (PositionList<Integer>) lista.elements();
		for(Integer el : listaElementiDoppioni)
			System.out.print(el+" ");
	
		 
		
	}

}
