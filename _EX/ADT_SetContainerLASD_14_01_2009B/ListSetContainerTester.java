package ADT_SetContainerLASD_14_01_2009B;

import position.NodePositionList;
import position.PositionList;
import set.ListSet;

public class ListSetContainerTester {
@SuppressWarnings("all")
	public static void main(String args[]){
		
		ListSetContainer<Integer> lista = new ListSetContainer<Integer>();
		
		PositionList<Integer> l2 = new NodePositionList<Integer>();
		l2.addLast(1);
		l2.addLast(2);
		l2.addLast(3);
		l2.addLast(4);
		l2.addLast(5);
		l2.addLast(6);
		l2.addLast(7);
		l2.addLast(8);
		l2.addLast(9);
		l2.addLast(10);
		ListSet<Integer> set2 = (ListSet<Integer>) lista.insert(l2);
		
		
		PositionList<Integer> l3 = new NodePositionList<Integer>();
		l3.addLast(12);
		l3.addLast(2);
		l3.addLast(3);
		l3.addLast(4);
		l3.addLast(5);
		l3.addLast(6);
		//l3.addLast(7);
		ListSet<Integer> set3 = (ListSet<Integer>) lista.insert(l3);
	
		
		PositionList<Integer> l4 = new NodePositionList<Integer>();
		l4.addLast(1);
		l4.addLast(2);
		l4.addLast(3);
		l4.addLast(4);
		ListSet<Integer> set1 = (ListSet<Integer>) lista.insert(l4);
		
		System.out.println("Insiemi inseriti nel contenitore:\n"+lista.toString());	
		System.out.println("Quantità di insiemi inseriti: "+lista.size());
		
		lista.add(set1, l3);
		System.out.println("Aggiungo un 'altra lista all'insieme SET1:\n"+lista.toString());
		
		PositionList<Integer> list = lista.remove();
		System.out.print("Rimuovo la lista avente numero minore di elementi:\n");
		for(Integer e : list)
			System.out.print(e+" ");
		
		System.out.println("\nInsiemi rimanenti nella lista:\n"+lista.toString());
		System.out.println("\nLa lista è vuota ? "+lista.isEmpty());
	}
}
