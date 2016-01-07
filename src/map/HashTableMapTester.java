package map;

import entry.Entry;

public class HashTableMapTester {

	public static void main (String...strings){
		
		
		HashTableMap<Integer, Integer> t = new HashTableMap<Integer, Integer>();
		
		t.put(12, 2);
		t.put(3, 42);
		t.put(1,17);
		t.put(8,13);
		t.put(7, 90);
		t.put(1, 0);
		t.put(1, 1009);
		
		for(Entry<Integer,Integer> e : t.entries()){
			System.out.print(e.getKey()+"-"+e.getValue()+" ");
		}
		
		System.out.println("\n<---------------------------->");
		
		
		for(Entry<Integer,Integer> e : t.sameHashEntries(1)){
			System.out.print(e.getKey()+"-"+e.getValue()+" ");
		}
		

		System.out.println("\n<---------------------------->");
		System.out.println(t.clusterSize(1));
	}
		
		
	
	
	
}
