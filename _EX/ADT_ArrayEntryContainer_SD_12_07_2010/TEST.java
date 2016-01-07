package ADT_ArrayEntryContainer_SD_12_07_2010;
import java.util.Comparator;

import position.PositionList;
import priorityQueue.DefaultComparator;
import priorityQueue.Entry;


public class TEST {

	public static void main(String[] args) {
		
		Comparator<Integer> cmp = new DefaultComparator<Integer>();
		ArrayEntryContainer<Integer,Integer> C = new ArrayEntryContainer<Integer,Integer>(cmp);

		C.add(1,3);
		C.add(3,12);
		C.add(4,5);
		C.add(4,90);
		C.add(11,2);
		C.add(9,7);
		C.add(6,7);
		C.add(4,12);
		C.add(11,3);
		C.add(11,22);
		C.add(11,44);
		
		
		System.out.println("La dimensione dell'array è: "+C.size());	
		System.out.println("\nL'array è vuoto? "+C.isEmpty());	
		System.out.println("\nGli elementi contenuti sono:\n"+C.toString());	
		
		System.out.println();
		PositionList<Entry<Integer,Integer>> lista = C.searchAll(4);
		for(Entry<Integer,Integer> e : lista )
			System.out.print(e.getKey()+"-"+e.getValue()+" ");
	
		System.out.println("\n\nI valori degli elementi con chiave maggiore che sono stati eliminati sono:");
		PositionList<Integer> list = C.remove();
		for(Integer c : list )
			System.out.print(c+" ");
		
		System.out.println("\nGli elementi contenuti sono:\n"+C.toString());	
		
		
	}

}
