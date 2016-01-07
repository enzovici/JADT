package deque;
import exception.EmptyDequeException; 

public interface Deque<E> {
	public int size();
	public boolean isEmpty();
	public E getFirst() throws EmptyDequeException;
	public E getLast() throws EmptyDequeException;
	public void addFirst(E elem);
	public void addLast(E elem);
	public E removeFirst() throws EmptyDequeException;
	public E removeLast() throws EmptyDequeException;

}
