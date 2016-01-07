package node;

public class DLNode<E> {
	private E element;
	private DLNode<E> next, prev;
	
	public DLNode(){
		this(null,null,null);
	}
	
	public DLNode(E e, DLNode<E> p, DLNode<E> n){
		element=e;
		prev=p;
		next=n;
	}
	
	//Metodi di modifica
	public void setElement(E newElem){
		element = newElem;
	}
	
	public void setPrev(DLNode<E> p){
		prev = p;
	}
	
	public void setNext(DLNode<E> n){
		next = n;
	}
	
	//metodi di accesso
	public E getElement(){
		return element;
	}
	
	public DLNode<E> getPrev(){
		return prev;
	}
	
	public DLNode<E> getNext(){
		return next;
	}
}
