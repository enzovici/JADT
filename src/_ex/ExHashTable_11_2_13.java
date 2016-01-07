package _ex;

import java.util.Comparator;

import dictionary.Dictionary;
import dictionary.LinearProbingHashTable;
import entry.Entry;



/*La funzione deve stampare:

Inizialmente la tabella contiene le entrate: 

(0,100) (1,8) (201,408) (1,7) (201,207) (200,300) (200,301) (120,220) (121,248) (121,127) 
(120,221) (121,16) (40,140) (41,88) (241,488) (41,47) (241,247) (240,340) (40,141) (240,341) 
(41,4) (160,260) (161,328) (161,167) (160,261) (80,180) (81,168) (281,568) (81,87) (281,287) 
(280,380) (80,181) (280,381) (81,6) 

Testiamo la funzione:
removeEntryWSV(1) rimuove l'entrata: (1,7) 
removeEntryWSV(21) non rimuove alcuna entrata
removeEntryWSV(41) rimuove l'entrata: (41,4) 
removeEntryWSV(61) non rimuove alcuna entrata
removeEntryWSV(81) rimuove l'entrata: (81,6) 
removeEntryWSV(101) non rimuove alcuna entrata
removeEntryWSV(121) rimuove l'entrata: (121,16) 
removeEntryWSV(141) non rimuove alcuna entrata
removeEntryWSV(161) rimuove l'entrata: (161,167) 
removeEntryWSV(181) non rimuove alcuna entrata
removeEntryWSV(201) rimuove l'entrata: (201,207) 
removeEntryWSV(221) non rimuove alcuna entrata
removeEntryWSV(241) rimuove l'entrata: (241,247) 
removeEntryWSV(261) non rimuove alcuna entrata
removeEntryWSV(281) rimuove l'entrata: (281,287) 
removeEntryWSV(41) rimuove l'entrata: (41,47) 
removeEntryWSV(61) non rimuove alcuna entrata
removeEntryWSV(81) rimuove l'entrata: (81,87) 
removeEntryWSV(101) non rimuove alcuna entrata
removeEntryWSV(121) rimuove l'entrata: (121,127) 
removeEntryWSV(141) non rimuove alcuna entrata
removeEntryWSV(161) rimuove l'entrata: (161,328) 
removeEntryWSV(181) non rimuove alcuna entrata
removeEntryWSV(201) rimuove l'entrata: (201,408) 
removeEntryWSV(221) non rimuove alcuna entrata
removeEntryWSV(241) rimuove l'entrata: (241,488) 
removeEntryWSV(261) non rimuove alcuna entrata
removeEntryWSV(281) rimuove l'entrata: (281,568) 
*/
 

public class ExHashTable_11_2_13 {

	
	public static void main(String[] args){
		ExamLinearProbingHashTable<Integer,Integer> D = new ExamLinearProbingHashTable<Integer,Integer>(100);
		
		for(int j=1;j<300;j=j+40) D.insert(j, j*2+6);
		for(int j=1;j<300;j=j+40) D.insert(j, j+6);
		for(int i=0 ;i<2;i++)
		  for(int j=i*40;j<300;j=j+40) D.insert(j, j+i+100);
		D.insert(121, 16);
		D.insert(41, 4);
		D.insert(81, 6);
		System.out.println("Inizialmente la tabella contiene le entrate: ");
	     int count=0;
		for(Entry<Integer,Integer> e:D.entries()) {
			if(count++%10==0) System.out.println();
		   System.out.print("("+e.getKey()+","+e.getValue()+")"+" ");
		} 
		
	    System.out.print("\n\nTestiamo la funzione:");		
		for(int i=1;i<300;i=i+20){
			System.out.print("\nremoveEntryWSV("+ i + ") " );
			Entry<Integer,Integer> e=D.removeEntryWSV(i,new IntegerComparator());
			if(e==null)	System.out.print("non rimuove alcuna entrata");
			else System.out.print("rimuove l'entrata: ("+e.getKey()+","+e.getValue()+")"+" ");
		}
		
		for(int i=41;i<300;i=i+20){
			System.out.print("\nremoveEntryWSV("+ i + ") " );
			Entry<Integer,Integer> e=D.removeEntryWSV(i,new IntegerComparator());
			if(e==null)	System.out.print("non rimuove alcuna entrata");
			else System.out.print("rimuove l'entrata: ("+e.getKey()+","+e.getValue()+")"+" ");
		}
	 
	
	
	
	}	
	
		
	
	
		
	
	   //classe che estende LinearProbingHashTable 
		public static class ExamLinearProbingHashTable<K,V> extends LinearProbingHashTable<K,V> implements Dictionary<K,V>{
			protected int c; 
			public ExamLinearProbingHashTable(int cap){
				super(cap);
			    c=cap;
			}
				
			
			public int hashValue(K key){
				 return (Integer)key%c;
			 }
			/**
			 * 
			 * La funzione prende in input una chiave key e un comparatore V che serve a confrontare i 
valori delle entrate. La funzione rimuove e restituisce in output l’entrata con chiave key che 
ha valore più piccolo. Se il dizionario non contiene alcuna entrata con chiave key allora la 
funzione deve restituire null.
• La funzione deve fare il “probe” solo di quelle celle che potrebbero effettivamente contenere 
un’entrata con chiave key e non deve invocare i metodi remove, keys, entries e findAll.
			 
			 */
			public Entry<K,V> removeEntryWSV(K key, Comparator<V> cv){
				checkKey(key);
				int i =hashValue(key);
				int j = i;
				int index = -1;
				Entry<K,V> min = null;
				do{
					if(bucket[i] == null && min == null)return null;
					
					if(bucket[i] == null && bucket[i] != AVAILABLE && bucket[i].getKey().equals(key)){
						if(min == null || cv.compare(bucket[i].getValue(),min.getValue())<0){
							min=bucket[i];
							index = i;
						}
					}
					
					i = (i + 1)%bucket.length;
					
				}while(j!=i);
				
				if(index >0){
					bucket[index] = AVAILABLE;
					n--;
				}
				
				return min;
				
			}
		
	
		
				
		}
			public static class IntegerComparator  implements Comparator<Integer> {
				 
				  public int compare(Integer a, Integer b) throws ClassCastException { 
					return(a-b);
					
				  }
				}
	

}
