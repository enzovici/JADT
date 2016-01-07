package _appelli;

import comparator.DefaultComparator;
import entry.Entry;
import map.ListMap;

//importare le classi necessarie



/**
 Aggiungere il metodo
public void removeSmallestValues(int m,Comparator<V> c)
alla classe ListMap.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione prende in input un intero m e un comparatore c che serve a confrontare oggetti
di tipo V. La funzione deve cancellare dalla mappa le m entrate con valore più piccolo. Se
la mappa contiene meno di m entrate, la funzione deve cancellare tutte le entrate.
• Se la mappa è vuota la funzione non deve fare niente.
• La funzione deve avere complessità O(n log n), dove n è il numero di entrate della mappa.
Le funzioni che non soddisfano questo requisito saranno valutate al massimo 13 punti. E`
previsto un bonus per le funzioni con complessità O(n + m log n).
La classe di test ExMap_25_6_12 deve essere inserita nel pacchetto in cui si trova l’interfaccia
Map.
 */

/*
Il programma deve stampare:
 
Inizialmente la mappa contiene le entrate 
<(0,z)(1,f)(2,k)(3,t)(4,o)(5,s)(6,p)(7,w)(8,s)(9,d)(10,s)(11,a)(12,g)(13,j)(14,h)(15,j)(16,p)(17,b)(18,x)(19,s)>

Dopo aver invocato removeSmallestValues(M,1) la mappa contiene le entrate 
<(0,z)(1,f)(2,k)(3,t)(4,o)(5,s)(6,p)(7,w)(8,s)(9,d)(10,s)(12,g)(13,j)(14,h)(15,j)(16,p)(17,b)(18,x)(19,s)>

Dopo aver invocato removeSmallestValues(M,2) la mappa contiene le entrate 
<(0,z)(1,f)(2,k)(3,t)(4,o)(5,s)(6,p)(7,w)(8,s)(10,s)(12,g)(13,j)(14,h)(15,j)(16,p)(18,x)(19,s)>

Dopo aver invocato removeSmallestValues(M,3) la mappa contiene le entrate 
<(0,z)(2,k)(3,t)(4,o)(5,s)(6,p)(7,w)(8,s)(10,s)(13,j)(15,j)(16,p)(18,x)(19,s)>

Dopo aver invocato removeSmallestValues(M,4) la mappa contiene le entrate 
<(0,z)(3,t)(5,s)(6,p)(7,w)(8,s)(10,s)(16,p)(18,x)(19,s)>
*/

public class ExMap_25_6_12 {

	


	public static void main(String[] args){
		ListMap<Integer,Character> M = new ListMap<Integer,Character>();
		String s="zfktospwsdsagjhjpbxs";
		for(int i=0;i<s.length();i++)
			M.put(i, s.charAt(i));
		
		System.out.print("Inizialmente la mappa contiene le entrate \n<");
		 for(Entry<Integer,Character> ent: M.entries())
			System.out.print ("("+ent.getKey()+","+ ent.getValue()+")");
	    System.out.println(">");
		for(int m=1;m<5;m++){
		 System.out.print("\nDopo aver invocato removeSmallestValues(M,"+m+") la mappa contiene le entrate \n<");
		 M.removeSmallestValues(m, new DefaultComparator());
		 for(Entry<Integer,Character> ent: M.entries())
			System.out.print ("("+ent.getKey()+","+ ent.getValue()+")");
		 	
		 System.out.println(">");
		}		
   }
		
		
				
		
		

}
