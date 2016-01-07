package ADT_ArrayEntryContainerSD_30_06_2010;

import java.util.Comparator;
import priorityQueue.DefaultComparator;

public class TEST {

	/*
	 * NOME:
	 * COGNOME:
	 * MATRICOLA:
	 */

	public static void main(String[] args) {
		
		Comparator<Integer> cmp = new DefaultComparator<Integer>();
		ArrayEntryContainer<Integer,Integer> C = new ArrayEntryContainer<Integer,Integer>(cmp);

		C.add(1,8);
		C.add(2,4);
		C.add(3,6);
		C.add(4,22);
		C.add(5,12);
		C.add(5,12);
		C.add(6,6);
		C.add(7,12);
		C.add(8,10);
		
	    System.out.println(C.size());	
		
		System.out.println(C.toString()+" ");
		
		System.out.println("\n"+C.search(5)+"\n");
		
		System.out.println(C.remove());
		
		System.out.println(C.size());	
			
		System.out.println(C.toString()+" ");
			
		System.out.println(C.remove());
		
		System.out.println(C.size());	
		
		System.out.println(C.toString()+" ");
		
		System.out.println(C.remove());
		
		System.out.println(C.size());	
		
		System.out.println(C.toString()+" ");
		
	}

}
