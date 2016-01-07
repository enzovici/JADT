package ADT_EntryContainerLASD_12_07_2010;

import priorityQueue.Entry;

public class ListEntryContainerTester {

	public static void main(String args[]){
		
		ListEntryContainer<Integer,Integer> lista = new ListEntryContainer<Integer, Integer>();
		lista.add(8,22);
		lista.add(4,33);
		Entry<Integer,Integer> e3 = lista.add(3,11);
		lista.add(1,44);
		lista.add(5,55);
		lista.add(7,66);
		lista.add(8,77);
		lista.add(9,88);
		lista.add(1,99);
		
		System.out.println(lista.size());
		System.out.println(lista.toString());
		
		lista.remove(e3);
		
		System.out.println(lista.size());
		System.out.println(lista.toString());
		
		lista.remove();
		System.out.println(lista.size());
		System.out.println(lista.toString());
		
	}
	
	
}
