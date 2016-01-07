package map;

import entry.Entry;

public class TestListMap {

	public static void main(String[] args) {
		ListMap<String,Integer> M = new ListMap<String,Integer>();
		
		M.put("mela", 1);
		M.put("pera", 2);
		M.put("arancia", 3);
		M.put("banana", 4);
		M.put("castagna", 5);
		
		for (Entry<String,Integer> e:M.entries()){
			System.out.print(e.getKey() + ", " + e.getValue() + " ");
			System.out.println(" ");
		}
		
		System.out.print("Rimuoviamo la chiave 3 (e' un value!). Valore restituito: " );
		System.out.println(M.remove("3"));
		
		System.out.println("Ecco le chiavi della mappa: " + M.toStringKey());
		System.out.println("Ecco i valori della mappa: " + M.toStringValue());
		System.out.println("Ecco le coppie (chiave/valore) della mappa: " + M.toStringKeyValue());
		
		System.out.println("Ecco le entries della mappa: " + M.toString());
		}
}
