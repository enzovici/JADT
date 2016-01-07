package ADT_QueueContainer;

import java.util.Comparator;
import position.*;
import queue.*;

public class ListQueueContainer<E> implements QueueContainer<E> {

	private PositionList<Queue<E>> lista;
	private Comparator<E> comp;
	
	public ListQueueContainer(DefaultComparator<E> c){
		lista = new NodePositionList<Queue<E>>();
		comp=c;
	}
	
	/** inserisce una nuova coda vuota nel contenitore restituendola in output.*/
	public Queue<E> insert() {
		
		ArrayQueue<E> coda = new ArrayQueue<E>();
		lista.addLast(coda);
		return coda;
	}
	
	/** fa un enqueue dell’elemento e sulla coda Q.*/
	public void enqueue(Queue<E> Q, E e) {
		
		ArrayQueue<E> coda = (ArrayQueue<E>) Q;
		coda.enqueue(e);
		mergeSort(lista);
	}

	public E dequeue(Queue<E> Q) {
		
		ArrayQueue<E> coda = (ArrayQueue<E>)Q;
		E elem = coda.dequeue();
		return elem;
	}

	/** rimuove dal contenitore la coda il cui front è il più piccolo fra tutti i front delle
	  * code presenti nel contenitore. In caso di più code con lo stesso front minimo, se ne rimuova 
	  * una qualsiasi fra queste. Il confronto fra i front delle code dovrà essere eseguito usando il comparatore
	  */
	public void remove() {
		
		lista.remove(lista.first());
	}

	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
	public int size(){
		return lista.size();
	}
	
	public String toString(){
		  
		String stampa = "";
		for(Queue<E> q : lista){
			for(int i = 0 ; i < q.size() ; i++){
				stampa+=q.front() + " ";
				q.enqueue(q.dequeue());
			}
		stampa+="\n";
		}
		return stampa;
	}
	
	private void mergeSort(PositionList<Queue<E>> L){
		
		int size = L.size();
		
		if(size<2)
			return;
		
		PositionList<Queue<E>> l1 = new NodePositionList<Queue<E>>();
		PositionList<Queue<E>> l2 = new NodePositionList<Queue<E>>();
		
		for(int i = 0;i<size/2 ; i++)
			l1.addLast(L.remove(L.first()));
		
		for(int i = 0;i<size/2 ; i++)
			l2.addLast(L.remove(L.first()));
		
		mergeSort(l1);
		mergeSort(l2);
		merge(l1,l2,L);
	}
	
	private void merge(PositionList<Queue<E>> l1, PositionList<Queue<E>> l2,PositionList<Queue<E>> L) {

		while(!l1.isEmpty() && !l2.isEmpty()){
			if(!l1.first().element().isEmpty() && !l2.first().element().isEmpty()){
				
				if(comp.compare(l1.first().element().front(),l2.first().element().front())<= 0)
					L.addLast(l1.remove(l1.first()));

				else 
					L.addLast(l2.remove(l2.first()));
			}

			else
				if(!l1.first().element().isEmpty())
					L.addLast(l1.remove(l1.first()));

				else 
					L.addLast(l2.remove(l2.first()));
		}

		while(!l1.isEmpty())
			L.addLast(l1.remove(l1.first()));

		while(!l2.isEmpty())
			L.addLast(l2.remove(l2.first()));
	}
}