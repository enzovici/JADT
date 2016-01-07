package ADT_QueueContainer;

import queue.ArrayQueue;

public class ListQueueContainerTester {

	public static void main(String...strings){
		
		
		DefaultComparator<Integer> c = new DefaultComparator<Integer>();
		ListQueueContainer<Integer> lista = new ListQueueContainer<Integer>(c);
		
		ArrayQueue<Integer> c1 = (ArrayQueue<Integer>) lista.insert();
		ArrayQueue<Integer> c2 = (ArrayQueue<Integer>) lista.insert();
		ArrayQueue<Integer> c3 = (ArrayQueue<Integer>) lista.insert();
		ArrayQueue<Integer> c4 = (ArrayQueue<Integer>) lista.insert(); 
		
		
		lista.enqueue(c1, 1);
		lista.enqueue(c1, 31);
		lista.enqueue(c1, 9);
		lista.enqueue(c1, 1);
		lista.enqueue(c1, 23);
		
		
		lista.enqueue(c2, 11);
		lista.enqueue(c2, 3);
		lista.enqueue(c2, 33);
		lista.enqueue(c2, 31);
		
		
		lista.enqueue(c3, 1);
		lista.enqueue(c3, 2);
		lista.enqueue(c3, 3);
	
	
		lista.enqueue(c4, 4);
		lista.enqueue(c4, 5);
	
		
		System.out.println("Elenco code inserite nel contenitore: \n"+lista.toString());
		
		
		
		lista.remove();
		
		System.out.println("prima rimozione:\n"+lista.toString());
		
		
		lista.remove();
		
		System.out.println("seconda rimozione:\n"+lista.toString());
		
	}
	
	
}
