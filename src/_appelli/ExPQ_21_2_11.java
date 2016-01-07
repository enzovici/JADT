package _appelli;

import java.util.Comparator;

import exception.EmptyPriorityQueueException;
import entry.Entry;
import priorityQueue.HeapPriorityQueue;
import priorityQueue.PriorityQueue;
import priorityQueue.SortedListPriorityQueue;
/**
 Scrivere la funzione
public static <K,V>void subtract (PriorityQueue<K,V> Q1, PriorityQueue <K,V> Q2,
Comparator<K>c )
nella classeExPQ_21_2_11 fornita dalla docente.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione prende in input due code a priorità Q1 e Q2 e un comparatore c dello stesso 
tipo usato per effettuare i confronti tra le chavi di Q1 e Q2.
• La funzione deve rimuovere da Q1 tutte le entrate le cui chiavi sono contenute in qualche 
entrata di Q2. 
• Se una delle due code a priorità è vuota la funzione deve lanciare l’eccezione 
EmptyPriorityQueueException.
• La funzione deve avere tempo di esecuzione lineare (in termini del numero di 
operazioni di Priority Queue) nella somma del numero di elementi di Q1 e Q2. In caso 
contrario la funzione sarà valutata al massimo 13 punti.
La classe di test ExPQ_21_2_11 deve essere inserita nel pacchetto in cui si trova l’interfaccia 
PriorityQueue
 */



public class ExPQ_21_2_11 {
	public static void main(String[] args){
	PriorityQueue <Integer,Integer> Q1 = new HeapPriorityQueue<Integer,Integer>(new IntegerComparator());
	PriorityQueue <Integer,Integer> Q2 = new HeapPriorityQueue<Integer,Integer>(new IntegerComparator());
	Q2.insert(1, 5) ;
	
	
	System.out.println("I test");
	try{
		  subtract(Q1,Q2, new IntegerComparator());
	   }
	   catch (EmptyPriorityQueueException err){
	    System.out.println("Errore: almeno una delle code a priorita` e` vuota");
	   }
	
	   System.out.println("\nII test");
	   System.out.println("La coda a priorita` Q1 contiene le entrate:");
	   for(int k=1;k<=14;k=k+2)
	   {
			Q1.insert(k,k);
			System.out.print("("+k+","+k+") ");
		 }
	   
	   System.out.println("\nLa coda a priorita` Q2 contiene le entrate:");
	   for(int k=1;k<=30;k=k+4)
			{
				Q2.insert(k,k);
			   System.out.print("("+k+","+k+") ");
			 }
	   System.out.println("\nDopo aver invocato subtract(Q1,Q2),  la coda a priorita` Q1 contiene le entrate:");
	  subtract(Q1,Q2,new IntegerComparator());
	   while(!Q1.isEmpty())
		  System.out.print("("+Q1.min().getKey()+","+Q1.removeMin().getValue()+") ");
	   
	   
	Q1= new HeapPriorityQueue<Integer,Integer>(new IntegerComparator());
	Q2 = new HeapPriorityQueue<Integer,Integer>(new IntegerComparator());
	System.out.println("\n\nIII test");
	System.out.println("La coda a priorita` Q1 contiene le entrate:");
   for(int k=1;k<=15;k=k+2)
	  for(int v=1;v<=k/3;v++){
		Q1.insert(k,v);
		System.out.print("("+k+","+v+") ");
	 }
   Q1.insert(25,54);
	System.out.print("(25,54) ");
   System.out.println("\nLa coda a priorita` Q2 contiene le entrate:");
   for(int k=1;k<=25;k=k+4)
		 for(int v=1;v<=k/4;v++){
			Q2.insert(k,v);
		   System.out.print("("+k+","+v+") ");
		 }
	
   System.out.println("\nDopo aver invocato subtract(Q1,Q2),  la coda a priorita` Q1 contiene le entrate:");
	  subtract(Q1,Q2,new IntegerComparator());
	   while(!Q1.isEmpty())
		  System.out.print("("+Q1.min().getKey()+","+Q1.removeMin().getValue()+") ");
	   
	}
	
	public static <K,V>void subtract (PriorityQueue<K,V> Q1, PriorityQueue <K,V> Q2 , Comparator<K>c){
		
		if(Q1.isEmpty())throw new EmptyPriorityQueueException("prima coda vuota");
		if(Q2.isEmpty())throw new EmptyPriorityQueueException("prima coda vuota");
		PriorityQueue<K, V> tmp = new SortedListPriorityQueue<K, V>();
	
		
		
		while(!(Q1.isEmpty()) && !(Q2.isEmpty())){
			Entry<K, V> qmin = Q1.min();
			Entry<K,V> en = Q2.min();
			int result = c.compare(qmin.getKey(),en.getKey() );
			
			if(result < 0){
				tmp.insert(qmin.getKey(), qmin.getValue());
				Q1.removeMin();
			}
			if(result > 0){
						Q2.removeMin();	
						}
			if(result == 0){
				Q1.removeMin();
			}

			
		}
		
		int num = tmp.size();
		
		while(num > 0){
			Entry<K,V> e = tmp.removeMin();
			Q1.insert(e.getKey(), e.getValue());
			
			num--;
		}
		
	}
	
	public static class IntegerComparator  implements Comparator<Integer> {
		 
		  public int compare(Integer a, Integer b) throws ClassCastException { 
			return(a-b);
			
		  }
	}
}
