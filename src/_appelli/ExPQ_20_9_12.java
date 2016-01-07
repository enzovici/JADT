package _appelli;


import java.util.Comparator;

import entry.Entry;
import comparator.DefaultComparator;
import priorityQueue.HeapPriorityQueue;
import priorityQueue.PriorityQueue;
//importare le classi necessarie

/**
 Scirvere la funzione
public static <V> PriorityQueue<Integer,V> f(PriorityQueue<Integer,V> P,
Comparator<V> cV)
nella classe ExPQ_20_9_12 fornita dalla docente
Istruzioni per lo svolgimento dell’esercizio:
• La funzione prende in input una coda a priorità P e un comparatore cV e restituisce in output
una coda a priorità che per ciascuna chiave k di P contiene l’entrata (k,v), dove v è il
minimo dei valori associati a k in P. I confronti tra i valori delle entrate devono essere
effettuati mediante il comparatore cV.
• Se P è vuota la funzione deve restituire una coda a priorità vuota.
• La funzione deve eseguire O(n) operazioni del TDA Priority Queue, dove n è la dimensione
di P.
• Non è necessario ripristinare il contenuto di P.
La classe di test ExPQ_20_9_12 deve essere inserita nel pacchetto in cui si trova la classe
PriorityQueue.
 */
/*
Il programma deve stampare:

I test: la coda a priorita` e` vuota.
La funzione invocata su una coda a priorita` vuota restituisce una coda a priorita` vuota.

II test:
Ora la coda a priorita` contiene le entrate:
(0,ou)(0,pt)(0,qs)(0,qa)(0,pb)(0,oc)(1,or)(1,pq)(1,qp)(1,ro)(1,qd)(1,pe)(1,of)(1,og)(1,ph)(2,on)(2,pm)(2,ql)(2,rk)(2,sj)(2,qi)(2,pj)(2,ok)(2,nl)(2,om)(2,pn)(2,qo)(3,oi)(3,ph)(3,qg)(3,rf)(3,se)(3,td)(3,qp)(3,pq)(3,or)(3,ns)(3,mt)(3,ou)(3,pv)(3,qw)(3,rx)

Le entrate contenute nella coda a priorita` restituita dalla funzione sono:
(0,oc) (1,of) (2,nl) (3,mt) 


*/
public class ExPQ_20_9_12 {
	 public static void main(String [] args){
	 PriorityQueue <Integer,String> PQ = new HeapPriorityQueue<Integer,String>(new IntegerComparator());
   
		
	 System.out.println("I test: la coda a priorita` e` vuota.");
	 if( f(PQ, new DefaultComparator<String>()).isEmpty()) 
	 System.out.println("La funzione invocata su una coda a priorita` vuota restituisce una coda a priorita` vuota.");
	   
	 System.out.println("\nII test:");
	 System.out.println("Ora la coda a priorita` contiene le entrate:");
	 char toAdd1= 'u';
	 char toAdd2= 'a';
		for(int i=0;i<=3;i++){
		
		for(char k='o';k<='q'+i;k++){
			PQ.insert(i, ""+k+toAdd1);
			System.out.print("(" + i+","+  ""+k+toAdd1-- +")");
		    }	 
		 
		for(char k='q';k>='p'-i;k--){
			PQ.insert(i, ""+k+toAdd2);
			System.out.print("(" + i+","+  ""+k+toAdd2++ +")");
		    }	
		
		for(char k='o';k<='o'+i;k++){
			PQ.insert(i, ""+k+toAdd2);
			System.out.print("(" + i+","+  ""+k+toAdd2++ +")");
		    }
		 
	}
   PriorityQueue<Integer,String> newP= f(PQ,new DefaultComparator<String>());
   System.out.println("\n\nLe entrate contenute nella coda a priorita` restituita dalla funzione sono:");
   while(!newP.isEmpty()){
        Entry<Integer,String> ent= newP.removeMin();	
  
	      System.out.print("("+ent.getKey()+","+ent.getValue()+") ");
	      
	}
		 
	      
	
}
	 
			
			
			


    //scrivere qui la funzione
	public static <V> PriorityQueue<Integer,V>  f(PriorityQueue<Integer,V> P, Comparator<V> cV){

		PriorityQueue<Integer, V> newQ = new HeapPriorityQueue<Integer, V>();
		if(P.isEmpty()) 
		return newQ;

		while(!P.isEmpty()){
		Entry<Integer, V> minEnt = P.removeMin();
		
		while(!P.isEmpty() && P.min().getKey() == minEnt.getKey()){
		Entry<Integer, V> currEnt = P.removeMin();
		
		if(cV.compare(minEnt.getValue(), currEnt.getValue()) > 0)
		minEnt = currEnt;
		}

		newQ.insert(minEnt.getKey(), minEnt.getValue());
		}
		return newQ;
		
		
		
	}
		 
		 
	public static class IntegerComparator  implements Comparator<Integer> {
		 
		  public int compare(Integer a, Integer b) throws ClassCastException { 
			return(a-b);
			
		  }
		  
	 }
}


	
	
	

