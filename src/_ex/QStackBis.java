package _ex;

import exception.EmptyStackException;
import queue.ArrayQueue;
import queue.Queue;
import stack.Stack;

public class QStackBis<E> implements Stack<E> {
	
	private Queue<E> Q;
	
	public QStackBis(){
		Q=new ArrayQueue<E>();
	}
	
	public int size(){
		return Q.size();
	}
	
	public boolean isEmpty(){
		return Q.isEmpty();
	}
	
	public E top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("Stack vuoto");
		return Q.front();
	}
	
	public E pop() throws EmptyStackException{//prelevamento
		if(isEmpty()) throw new EmptyStackException("Stack vuoto");
		return Q.dequeue();
	}
	
	public void push(E x){//inserimento
		Q.enqueue(x);
		for(int i=0;i<size()-1;i++)
			Q.enqueue(Q.dequeue());
	}

}
