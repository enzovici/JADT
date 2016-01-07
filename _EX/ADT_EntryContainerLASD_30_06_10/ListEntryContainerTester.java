package ADT_EntryContainerLASD_30_06_10;

import priorityQueue.Entry;

public class ListEntryContainerTester {
@SuppressWarnings("all")
	public static void main(String[] args) {

		ListEntryContainer<Integer,Integer> lista = new ListEntryContainer<Integer,Integer>();
		
		Entry<Integer,Integer> e1 = lista.add(1, 5);
		Entry<Integer,Integer> e2 = lista.add(4, 35);
		Entry<Integer,Integer> e3 = lista.add(2, 25);
		Entry<Integer,Integer> e4 = lista.add(3, 15);
		Entry<Integer,Integer> e5 = lista.add(8, 95);
		Entry<Integer,Integer> e6 = lista.add(7, 35);
		
		
		System.out.println(lista.toString());
		
		Integer a = lista.remove(e1);
		System.out.println("Il valore rimosso è: "+a+"\nLa nuova lista è: "+lista.toString());
		System.out.println();
		Integer e = lista.remove();
		System.out.println("Il valore più piccolo delle chiavi rimosso è: "+e+"\nLa nuova lista è: "+lista.toString());
		System.out.println();
		Integer d = lista.remove();
		System.out.println("Il valore più piccolo delle chiavi rimosso è: "+d+"\nLa nuova lista è: "+lista.toString());
		
		System.out.println("La lista è vuota? "+lista.isEmpty());
		System.out.println("Le dimensione della lista: "+lista.size());
		
		
	}

}
