package _ex;

import java.util.Iterator;

import arrayList.IndexList;

import exception.BoundaryViolationException;
import exception.EmptyQueueException;

import queue.ArrayQueue;

public class QueueIndexList<E> implements IndexList<E> {
	
	private ArrayQueue<E> Q = new ArrayQueue<E>();
	
	public QueueIndexList(){
		
	}
	
	public void checkIndex(int i, int size){
		if(i < 0 || i > size)throw new BoundaryViolationException("indice non valido");
	
	}
	

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		if(Q.isEmpty())throw new EmptyQueueException("coda vuota");
		checkIndex(i,Q.size() -1);
		E toReturn = null;
		for(int j = Q.size() -1;j >=i; j--){
			E tmp = Q.dequeue();
			if(j != i){
			Q.enqueue(tmp);
			}else{
				toReturn = tmp;
			}
		}
		
		for(int j = i; j >= 0; i++){
			E tmp = Q.dequeue();
			Q.enqueue(tmp);
		}
		
		return toReturn;
	}

	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		if(Q.isEmpty())throw new EmptyQueueException("coda vuota");
		checkIndex(i,Q.size() -1);
		E toReturn = null;
		for(int j = Q.size() -1;j >=0; j--){
			E tmp = Q.dequeue();
			if(j == i){
			toReturn = tmp;
			}
		}
		
		
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return Q.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Q.size();
	}


}
