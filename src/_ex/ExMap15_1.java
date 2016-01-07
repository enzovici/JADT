package _ex;
import java.util.Comparator;
import java.util.Iterator;

import dictionary.Dictionary;
import dictionary.LinearProbingHashTable;
import entry.*;

import map.HashTableMap;
import map.ListMap;
import map.Map;

/*Il programma deve stampare (ovviamente le entrate di M e D possono essere stampate in un diverso ordine):
I test:
M e` vuota 
D = < (50,29) (50,39) (50,49) (70,39) (70,49) (70,59) (70,69) (90,49) (90,59) (90,69) (90,79) (90,89) (10,9) (30,19) (30,29) >
Dopo aver invocato addEntries su M e D, si ha M=< (90,49) (70,39) (50,29) (30,19) (10,9) >

II test: 
M=< (90,49) (70,39) (50,29) (30,19) (10,9) >
D = < (50,29) (50,39) (50,49) (50,28) (70,39) (70,49) (70,59) (70,69) (70,38) (90,49) (90,59) (90,69) (90,79) (90,89) (90,48) (10,9) (10,8) (30,19) (30,29) (30,18) >.
Nota che la mappa M contiene le entrate inserite dalla prima chiamata di addEntries
e che al dizionario D sono state aggiunte le entrate (50,28) (30,18) (90,48) (10,8) (70,38).
Dopo aver invocato addEntries su M e D, si ha M=< (90,49) (70,39) (50,29) (30,19) (10,9) >.
 
 */

public class ExMap15_1 {
	public static void main(String[] args){
		Map<Integer,Integer> M = new HashTableMap<Integer,Integer>();
		Dictionary<Integer,Integer> D= new LinearProbingHashTable<Integer,Integer>();
		System.out.println("I test:");
		System.out.println("M e` vuota ");
		for(int i=10;i<100;i=i+20)
			for(int j=i/2+4;j<i;j=j+10)
			D.insert(i, j);
		Iterator<Entry<Integer,Integer>> itD= D.entries().iterator();
		System.out.print("D = < ");
		while(itD.hasNext())
		 System.out.print(itD.next()+" ");
		System.out.println(">");
		
		addEntries(M,D,new IntegerComparator());
		Iterator<Entry<Integer,Integer>> itM= M.entries().iterator();
		System.out.print("Dopo aver invocato addEntries su M e D, si ha M=< ");
		while(itM.hasNext())
		  System.out.print(itM.next()+" ");
		System.out.println(">");
		
		
		System.out.println("\nII test: ");
		itM= M.entries().iterator();
		System.out.print("M=< ");
		while(itM.hasNext())
		  System.out.print(itM.next()+" ");
		System.out.println(">");
		for(int i=10;i<100;i=i+20)
			D.insert(i, i/2+3);
	    itD= D.entries().iterator();
		System.out.print("D = < ");
		while(itD.hasNext())
		 System.out.print(itD.next()+" ");
		System.out.println(">.");
		System.out.println("Nota che la mappa M contiene le entrate inserite dalla prima chiamata di addEntries");
		System.out.println("e che al dizionario D sono state aggiunte le entrate (50,28) (30,18) (90,48) (10,8) (70,38).");
		addEntries(M,D,new IntegerComparator());
		itM= M.entries().iterator();
		System.out.print("Dopo aver invocato addEntries su M e D, si ha M=< ");
		while(itM.hasNext())
		  System.out.print(itM.next()+" ");
		System.out.println(">.");
		
		
	  
	}			
	
	//scrivere qui la funzione
      public static <K> void addEntries(Map<K,K> M, Dictionary<K,K> D, Comparator<K> c){
    	  
    	  
    	Iterable<Entry<K,K>> diz = D.entries();
    	Map<K,K> auxM = new ListMap<K,K>();   
    	//  Iterable<K> map = M.keys();
    	  
    	  for (Entry<K,K> entry : diz){
    		  
    		K a =  M.get(entry.getKey());
    		
    		if (a == null){
    			
    			auxM.put(entry.getKey(),entry.getKey());
    			
    			
//    			K min=entry.getValue();
//    			Iterable <Entry<K,K>> entr = D.findAll(a);
//    				for( Entry<K, K> e : entr)
//    				{
//    					int b = c.compare(min, e.getValue());
//    					if(b>0){
//    						min=e.getValue();
//    					}
//    				}
//    				M.put(entry.getKey() ,min);	
    			
    		}
    		
    		  
    	  }
    	  
    	  for (Entry<K,K> entry : diz){
    		  if(auxM.get(entry.getKey())!=null)
    			  if(M.get(entry.getKey())==null||c.compare(M.get(entry.getKey()),entry.getValue())>0)
    				  M.put(entry.getKey(),entry.getValue());
    	  }
    	  
    	  
    	  
      }


       public static class IntegerComparator  implements Comparator<Integer> {
		 
		  public int compare(Integer a, Integer b) throws ClassCastException { 
			return(a-b);
			
		  }
}
}