package _ex;

import queue.NodeQueue;
import queue.Queue;
import exception.EmptyStackException;
import stack.Stack;

//esercizio
public class QStack<E> implements Stack<E> {

	private Queue<E>Q;
	
	public QStack(){
		Q=new NodeQueue();
	}
	
	public int size(){
		return Q.size();
	}
	
	public boolean isEmpty(){
		return Q.isEmpty();
	}
	
	public E top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException("stack vuoto");
		for(int i=0;i<size()-1;i++)
			Q.enqueue(Q.dequeue());
		E tmp=Q.dequeue();
		Q.enqueue(tmp);
		return tmp;
		}
	
	public E pop() throws EmptyStackException{//prelevamento
		if(isEmpty()) throw new EmptyStackException("stack vuoto");
		for(int i=0;i<size()-1;i++)
			Q.enqueue(Q.dequeue());
		return Q.dequeue();
	}
	
	public void push(E x){//inserimento
		Q.enqueue(x);
	}

}
