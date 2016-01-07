package ADT_ArrayQueueSD;

import java.util.Comparator;

import position.NodePositionList;
import position.PositionList;
import queue.Queue;
@SuppressWarnings("all")
public class ArrayQueueContainer<E> implements QueueContainer<E> {


	private Queue<E> [] array;
	private int size;
	private Comparator<E> comp;
	private int capacity=100;

	public ArrayQueueContainer(){
		array = (Queue<E>[]) new Queue[capacity];
		size=0;
		comp = new DefaultComparator<E>();
	}


	public Queue<E> insert(E e) {

		MyQueue<E> coda = new MyQueue<E>();
		coda.enqueue(e);

		if(size==0){
			array[size] = coda;
			size++;
			coda.setIndex(0);
			return coda;
		}

		for(int i=0 ; i<size ; i++)
			if(comp.compare(coda.front(),array[i].front())< 0){
				for(int j=size ; j>i ; j--){
					((MyQueue<E>) array[j-1]).setIndex(j);
					array[j] = array[j-1];
				}

				array[i]=coda;
				size++;
				coda.setIndex(i);
				return coda;
			}

		array[size] = coda;
		coda.setIndex(size);
		size++;
		return coda;
	}


	public Queue<E> enqueue(Queue<E>Q, E e) {

		MyQueue<E> coda = (MyQueue<E>) Q;
		coda.enqueue(e);
		ordinaQueue(coda);
		return coda;
	}

	public E dequeue(Queue<E> Q) {

		MyQueue<E> coda = (MyQueue<E>) Q;
		E elemRimosso = coda.dequeue();
		ordinaQueue(coda);
		return elemRimosso;
	}


	public PositionList<Queue<E>> searchAll(E elem) {

		PositionList<Queue<E>> lista = new NodePositionList<Queue<E>>();
		ricercaBinaria(elem,0,size-1,lista);

		return lista;
	}

	/** rimuove dal contenitore la coda avente il maggior grado massimo di front.*/
	public void remove() {
		size--;
	}

	/** rimuove dal contenitore il grafo in input. */
	public void remove2(Queue<E> c) {

		MyQueue<E> coda = (MyQueue<E>) c;

		for(int i = coda.getIndex() ; i<size ; i++){
			array[i] = array[i+1];
			((MyQueue<E>)array[i]).setIndex(i);
		}
		size--;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public int size() {
		return size;
	}

	public String toString(){
		String stampa="";

		for(int i = 0;i<size;i++){
			stampa+="[";
			for(int j=0;j<array[i].size();j++){
				stampa+=array[i].front()+"-";
				array[i].enqueue(array[i].dequeue());
			}
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="] ";
		}
		return stampa;
	}

	public void ordinaQueue(Queue<E> q){

		MyQueue<E> coda=(MyQueue<E>) q;

		if(coda.getIndex()!=size-1){
			MyQueue<E> codaNext = (MyQueue<E>) array[coda.getIndex()+1];

			while(true){
				if(comp.compare(coda.front(),codaNext.front())>=0){
					MyQueue<E> temp = (MyQueue<E>) array[coda.getIndex()];
					array[coda.getIndex()] = array[codaNext.getIndex()];
					array[codaNext.getIndex()] = temp;

					((MyQueue<E>)array[codaNext.getIndex()]).setIndex(coda.getIndex());
					((MyQueue<E>)array[coda.getIndex()]).setIndex(codaNext.getIndex()+1);
				}

				if(codaNext.getIndex() == (size-1))
					return;

				else
					codaNext = (MyQueue<E>) array[codaNext.getIndex()+1];
			}
		}

	}

	public void ricercaBinaria(E elem,int low,int high,PositionList<Queue<E>> lista){

		if(low>high)
			return;

		if(high==0){
			if(comp.compare(elem,array[high].front())== 0){
				lista.addLast(array[high]);
				return;
			}
			else
				return;
		}

		int middle = (low+high)/2;
		int comparazione = comp.compare(elem,array[middle].front());

		if(comparazione == 0){
			lista.addLast(array[middle]);
			ricercaBinaria(elem,low,middle-1,lista);
			ricercaBinaria(elem,middle+1,high,lista);
		}

		else
			if(comparazione >= 0)
				ricercaBinaria(elem,middle+1, high, lista);

			else
				ricercaBinaria(elem,low,middle-1, lista);
	}
}