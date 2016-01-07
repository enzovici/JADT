package dictionary;

import entry.Entry;

public class TestChainingHashTable {
	public static void main(String[] args){
		ChainingHashTable<Integer,String> a = new ChainingHashTable<Integer,String>();
		a.insert(2, "Pietro");
		a.insert(2, "Luca");
		
		Entry<Integer,String> e = a.find(2);
		System.out.println("La chiave 2 ha valore: ");
		System.out.println(e.getValue());
		
		
		System.out.println("La chiavi con valore 2 sono: ");
		Iterable<Entry<Integer,String>> entries = a.findAll(2);
		for(Entry<Integer,String> e_ : entries)
			System.out.println(e.getKey() + "-" + e_.getValue());
	}
}
