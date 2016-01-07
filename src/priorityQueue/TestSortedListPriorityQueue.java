package priorityQueue;

import entry.Entry;
import exception.EmptyPriorityQueueException;
import priorityQueue.SortedListPriorityQueue;

public class TestSortedListPriorityQueue {

	public static void main(String[] args) throws EmptyPriorityQueueException
	{
		SortedListPriorityQueue<Integer,String> pq = new 
				SortedListPriorityQueue<Integer, String>();
		System.out.println("Creo una nuova coda a priorità  con 3 elementi");
		
		pq.insert(0, "Ciao");
		pq.insert(2, "Ok");
		pq.insert(-1, "Ehi");
		System.out.print("Stampo la coda. Dovrei ottenere: ");
		System.out.println("{(-1, ehi), (0, ciao), (2, ok)} ed ho: ");
		System.out.println(pq.toString());
		
		System.out.println("Rimuovo la chiave minima");
		System.out.print("Dovrei ottenere -1: Ehi e ottengo: ");
		Entry<Integer, String> entry_1 = pq.removeMin();
		System.out.println(entry_1.getKey() + ": " + entry_1.getValue());
		
		System.out.println("Rimuovo la chiave minima");
		System.out.print("Dovrei ottenere 0: Ciao e ottengo: ");
		Entry<Integer, String> entry_2 = pq.removeMin();
		System.out.println(entry_2.getKey() + ": " + entry_2.getValue());
		
		System.out.println("Aggiungo una nuova entry");
		pq.insert(-2, "New");
		System.out.println("Leggo la chiave minima");
		System.out.print("Dovrei ottenere -2: New e ottengo: ");
		Entry<Integer, String> entry_3 = pq.min();
		System.out.println(entry_3.getKey() + ": " + entry_3.getValue());
		
	}

	
}
