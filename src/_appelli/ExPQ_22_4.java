package _appelli;

import comparator.DefaultComparator;
import priorityQueue.HeapPriorityQueue;

import java.util.Comparator;
import java.util.Iterator;

import exception.EmptyPriorityQueueException;
import entry.Entry;

import priorityQueue.PriorityQueue;


import nodeList.NodePositionList;
import nodeList.PositionList;


/**
 Scrivere la funzione
public static Iterable<Entry<Integer,Integer>>sumOfValues
(SortedListPriorityQueue<Integer,Integer> P)
nella classe ExPQ_22_4_13.
Istruzioni per lo svolgimento dell’esercizio:
• Per ciascuna chiave presente nella coda a priorita P, la funzione computa la somma dei
valori associati alla chiave e restituisce una collezione iterabile di entrate di entrate della
forma (k,sumk) dove k è una chiave di P e sumk è la somma dei valori ad essa associati in
P. Ciascun chiave deve comparire esattamente una volta nelle entrate della collezione
output.
• La funzione deve avere tempo di esecuzione O(n) nel caso pessimo, dove n è il numero di
entrate della coda a priorità. Le funzioni con tempo di esecuzione O(cn), dove c è il numero
di chiavi distinte presenti in P, saranno valutate al massimo 15 punti. Le altre funzioni
saranno valutate al massimo 10 punti.
La classe di test ExPQ_22_4_13 deve essere inserita nel pacchetto in cui si trova l’interfaccia
PriorityQueue.
 */
/*Il programma deve stampare:
I test:
La coda a priorita` e` vuota.

II test:
La coda a priorita` contiene le entrate:
("1","1")("3","1")("5","1")("7","1")("9","1")("1","2")("3","2")("5","2")("7","2")("9","2")

Nella coda non ci sono chiavi comprese tra "0" e "1" oppure 
almeno una delle chiavi "0" e "1" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "2" oppure 
almeno una delle chiavi "0" e "2" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "3" oppure 
almeno una delle chiavi "0" e "3" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "4" oppure 
almeno una delle chiavi "0" e "4" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "5" oppure 
almeno una delle chiavi "0" e "5" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "6" oppure 
almeno una delle chiavi "0" e "6" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "7" oppure 
almeno una delle chiavi "0" e "7" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "0" e "8" oppure 
almeno una delle chiavi "0" e "8" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "1" e "2" oppure 
almeno una delle chiavi "1" e "2" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "1" e "3" oppure 
almeno una delle chiavi "1" e "3" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "1" e "4" oppure 
almeno una delle chiavi "1" e "4" non appartiene alla coda

Le entrate con chiave compresa tra "1" e "5" sono:
("3","1")("3","2")

Nella coda non ci sono chiavi comprese tra "1" e "6" oppure 
almeno una delle chiavi "1" e "6" non appartiene alla coda

Le entrate con chiave compresa tra "1" e "7" sono:
("3","1")("3","2")("5","2")("5","1")

Nella coda non ci sono chiavi comprese tra "1" e "8" oppure 
almeno una delle chiavi "1" e "8" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "3" oppure 
almeno una delle chiavi "2" e "3" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "4" oppure 
almeno una delle chiavi "2" e "4" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "5" oppure 
almeno una delle chiavi "2" e "5" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "6" oppure 
almeno una delle chiavi "2" e "6" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "7" oppure 
almeno una delle chiavi "2" e "7" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "2" e "8" oppure 
almeno una delle chiavi "2" e "8" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "3" e "4" oppure 
almeno una delle chiavi "3" e "4" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "3" e "5" oppure 
almeno una delle chiavi "3" e "5" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "3" e "6" oppure 
almeno una delle chiavi "3" e "6" non appartiene alla coda

Le entrate con chiave compresa tra "3" e "7" sono:
("5","2")("5","1")

Nella coda non ci sono chiavi comprese tra "3" e "8" oppure 
almeno una delle chiavi "3" e "8" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "4" e "5" oppure 
almeno una delle chiavi "4" e "5" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "4" e "6" oppure 
almeno una delle chiavi "4" e "6" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "4" e "7" oppure 
almeno una delle chiavi "4" e "7" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "4" e "8" oppure 
almeno una delle chiavi "4" e "8" non appartiene alla coda

Nella coda non ci sono chiavi comprese tra "3" e "6" oppure 
almeno una delle chiavi  "3" e "6" non appartiene alla coda
*/


public class ExPQ_22_4 {

	
	public static void main(String[] args){
		PriorityQueue <String,String> PQ = new HeapPriorityQueue<String,String>(new DefaultComparator<String>());
	    Comparator<String> c= new DefaultComparator<String>();
		System.out.println("I test:"); 
	    try{
			  eltsBetween(PQ,c, "a","d");
		   }
		   catch (EmptyPriorityQueueException err){
		    System.out.println("La coda a priorita` e` vuota.");
		   }
		System.out.println("\nII test:"); 
		System.out.println("La coda a priorita` contiene le entrate:");
	    for(int i=1;i<=2;i++)
		 for(int k=1;k<=10;k=k+2){
			PQ.insert(""+k,""+i);
			
			  System.out.print("(\"" + k+"\",\""+ i+"\")");
		}
       
		
		
		for(int i=0;i<=4;i++)
			 for(int j=i+1;j<=8;j++){
			   Iterator<Entry<String,String>> it= eltsBetween(PQ, c,""+i,""+j).iterator();
		      
		       if(!it.hasNext()) System.out.print("\n\nNella coda non ci sono chiavi comprese tra \""+ i +"\" e \""+ j+"\" oppure \nalmeno una delle chiavi \""+ i +"\" e \""+ j+"\" non appartiene alla coda");
		       
		       else System.out.println("\n\nLe entrate con chiave compresa tra \""+ i +"\" e \""+ j+"\" sono:");
		       while(it.hasNext()){
		        Entry<String,String> e= it.next();
			    System.out.print("(\"" + e.getKey()+"\",\""+ e.getValue()+"\")");
		       }
		       	
			 }
		
		Iterator<Entry<String,String>> it= eltsBetween(PQ, c,"3","6").iterator();
		if(!it.hasNext()) System.out.print("\n\nNella coda non ci sono chiavi comprese tra \"3\" e \"6\" oppure \nalmeno una delle chiavi  \"3\" e \"6\" non appartiene alla coda");
	       
	       else System.out.println("\n\nLe entrate con chiave compresa tra  \"3\" e \"6\" sono:");
	       while(it.hasNext()){
		   Entry<String,String> e= it.next();
		   System.out.print("(\"" + e.getKey()+"\",\""+ e.getValue()+"\")");
	 
		 }
		
	}  
	 
	
	
	

	
	
	public static <K,V> Iterable<Entry<K,V>> eltsBetween(PriorityQueue<K,V>  P,Comparator<K>  C, K k1, K k2)throws EmptyPriorityQueueException{
		
		if(P.isEmpty())throw new EmptyPriorityQueueException("coda vuota");
		PositionList<Entry<K,V>> L = new NodePositionList<Entry<K,V>>();
		int num = P.size();
		PriorityQueue<K, V> tmp = new HeapPriorityQueue<K,V>();
		Entry<K,V> en;
		int flag1 = 0;
		int flag2 = 0;
		while(num > 0){
			 en = P.removeMin();
			
			if((C.compare(en.getKey(),k1) > 0)&& (C.compare(en.getKey(), k2) < 0)){
				L.addLast(en);
			}
			if(C.compare(k1, en.getKey()) ==0 )flag1 = 1;
			
			if(C.compare(k2, en.getKey()) ==0 )flag2 = 1;
			
			tmp.insert(en.getKey(),en.getValue());
			
			num--;
		}
		
		num = tmp.size();
		while(num > 0){
			 en = tmp.removeMin();
			P.insert(en.getKey(), en.getValue());
			num--;
		}
		if(flag1 == 0 || flag2 == 0) {
			L = new NodePositionList<Entry<K,V>>();
		}
		return L;
		
		}
	



			
		  
	

}
