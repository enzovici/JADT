package priorityQueue;

import entry.Entry;
import exception.EmptyPriorityQueueException;


public class TestUnsortedListPrioriryQueue {


	public static void main(String[] args) throws EmptyPriorityQueueException {
		UnsortedListPriorityQueue<Integer, String> pq = new UnsortedListPriorityQueue<Integer, String>();
		
		System.out.println("Creo una nuova coda a priorità  con 3 elementi");
		pq.insert(0, "Ciao");
		pq.insert(2, "Ok");
		pq.insert(-1, "Ehi");
		
		System.out.println("Rimuovo la chiave minima");
		System.out.print("Dovrei ottenere -1: E ottengo: ");
		Entry<Integer, String> entry_1 = pq.removeMin();
		System.out.println(entry_1.getKey() + ": " + entry_1.getValue());
		
		System.out.println("Rimuovo la chiave minima");
		System.out.print("Dovrei ottenere 0: Ciao e ottengo: ");
		Entry<Integer, String> entry_2 = pq.removeMin();
		System.out.println(entry_2.getKey() + ": " + entry_2.getValue());
		
		System.out.println("Leggo la chiave minima");
		System.out.print("Dovrei ottenere 2: Ok e ottengo: ");
		Entry<Integer, String> entry_4 = pq.min();
		System.out.println(entry_4.getKey() + ": " + entry_4.getValue());
		
		System.out.println("Aggiungo una nuova entry");
		pq.insert(-2, "New");
		System.out.println("Leggo la chiave minima");
		System.out.print("Dovrei ottenere -2: New e ottengo: ");
		Entry<Integer, String> entry_3 = pq.min();
		System.out.println(entry_3.getKey() + ": " + entry_3.getValue());
		
	}
}
