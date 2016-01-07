package queue;

import exception.EmptyQueueException;

public interface Queue <E> {
	public void enqueue(E x);
	public E dequeue() throws EmptyQueueException;
	public E front() throws EmptyQueueException;
	public int size();
	public boolean isEmpty();
}
