package _ex;

import java.util.Comparator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import priorityQueue.PriorityQueue;
import priorityQueue.SortedListPriorityQueue;
import comparator.DefaultComparator;


public class Esercizi_PQDM {
	
	
//	
//	La funzione prende in input una coda a priorità P e un comparatore cV e restituisce in 
//	output una coda a priorità che per ciascuna chiave k di P contiene l’entrata (k,v), dove v 
//	è il minimo dei valori associati a k in P. I confronti tra i valori delle entrate devono 
//	essere effettuati mediante il comparatore cV.
	
	public static <V> PriorityQueue<Integer,V> f(PriorityQueue<Integer,V> P,Comparator<V> cV) {
		
		PriorityQueue<Integer,V> output =(PriorityQueue<Integer, V>) new SortedListPriorityQueue<Integer,V>();
		if(!P.isEmpty()){
			int tempk=0;
			V tempv=null;
			for(int i = 0;i<P.size();i++){
				Entry<Integer, V> tempEntry = P.removeMin();
				if (i==0) { 
				tempk = tempEntry.getKey();
				tempv = tempEntry.getValue();
				}
				else{
					if(tempk==tempEntry.getKey()){				
						if(cV.compare(tempEntry.getValue(), tempv) < 0)
							tempv=tempEntry.getValue();
					}			
					else{
						output.insert(tempk, tempv);
						tempk = tempEntry.getKey();
						tempv = tempEntry.getValue();
					}
				}	
			}	
		}
		return output;
	}

	
//	
//	Scrivere la funzione 
//	 public static <K,V> PositionList<Entry<K,V> > sort(SortedListPriorityQueue<K,V> 
//	Q1, SortedListPriorityQueue<K,V> Q2, Comparator <K> c). 
//	 Indicazioni per lo svolgimento dell’esercizio: 
//	• La funzione deve prendere in input due code a priorità Q1 e Q2 e un comparatore c 
//	(dello stesso tipo usato dalle due code) e restituire una lista contenente tutte le entrate di 
//	Q1 e Q2 ordinate in base ai valori delle chiavi. 
//	• La funzione deve avere complessità O(n) dove n è il numero totale di elementi di Q1 e 
//	Q2. 

	
	
	 public static <K,V> PositionList<Entry<K,V> > sort(SortedListPriorityQueue<K,V> 
	Q1, SortedListPriorityQueue<K,V> Q2, Comparator <K> c){
		
		PositionList<Entry<K,V>> output =(PositionList<Entry<K,V>>) new NodePositionList<Entry<K,V>>();

		 Entry<K,V> tempEntry;
		
		 
		 
		 while(!Q1.isEmpty() && !Q2.isEmpty()){
		 			int a= c.compare(Q1.min().getKey(), Q2.min().getKey());
		 			
		 			if (a<0){ 
		 				tempEntry = Q1.removeMin();
		 				output.addLast(tempEntry);}
		 			
		 			if (a==0){ 
		 				tempEntry = Q1.removeMin();
		 				output.addLast(tempEntry);
		 				tempEntry = Q2.removeMin();
		 				output.addLast(tempEntry);}
		 			
		 			if (a>0){ 
		 				tempEntry = Q2.removeMin();
		 				output.addLast(tempEntry);}
			
			}
		 
		 
		if(Q1.isEmpty()){
			 
			 for (int i=0;i<Q2.size();i++){
				 tempEntry = Q2.removeMin();
				 output.addLast(tempEntry);}
				 
		 }
		 
		else if(Q2.isEmpty()){
			 
			 for (int i=0;i<Q1.size();i++){
				 tempEntry = Q1.removeMin();
				 output.addLast(tempEntry);}
				 
		 }
		 
		 
		 return output;
		 
		 
		 
		 
		 
	 }
	
	
	
	
	public static void main(String[] args) {
		
	
			
					
		
		
	
SortedListPriorityQueue<Integer,Integer> pq = new 
SortedListPriorityQueue<Integer, Integer>();
System.out.println("Creo una nuova coda a priorità  con 3 elementi");

pq.insert(0, 23);
pq.insert(2, 2);
pq.insert(-1, 4);
pq.insert(0, 5);
pq.insert(3, 6);
pq.insert(3, 4);
pq.insert(4, 5);
pq.insert(1,4);
pq.insert(5, 5);
System.out.print("Stampo la coda");
//System.out.println("{(-1, ehi), (0, ciao), (2, ok)} ed ho: ");
System.out.println(pq.toString());



SortedListPriorityQueue<Integer,Integer> pq2 = new 
SortedListPriorityQueue<Integer, Integer>();
System.out.println("Creo una nuova coda a priorità  con 3 elementi");

pq2.insert(4, 3);
pq2.insert(3, 52);
pq2.insert(-1, 4);
pq2.insert(0, 5);
pq2.insert(3, 5);
pq2.insert(3, 3);
pq2.insert(4, 54);
pq2.insert(1,2);
pq2.insert(5, 1);
System.out.print("Stampo la coda. Dovrei ottenere: ");
//System.out.println("{(-1, ehi), (0, ciao), (2, ok)} ed ho: ");
System.out.println(pq2.toString());




Comparator<Integer> cV =new DefaultComparator<Integer>();


PriorityQueue<Integer,Integer> a = f(pq, cV);

System.out.println("output f");

System.out.println(a.toString());

SortedListPriorityQueue<Integer,Integer> b=(SortedListPriorityQueue<Integer, Integer>) a;
System.out.println("output sort");
System.out.println(sort(b,pq2,cV).toString());

		
	}

	
	
	
	
	
	

}
