package node;

public class Node <E>{
	private E element;
	private Node <E> next;
	
	//costruttore di default:
	public Node(){
		this(null,null);
	}
	
	//costruttore parametrico:
	public Node(E e, Node<E> n){
		element=e;
		next=n;
	}
	
	//metodi di accesso:
	public E getElement(){
		return element;
	}
	public Node <E>getNext(){
		return next;
	}
	
	//metodi di modifica:
	public void setElement(E newElement){
		element= newElement;
	}
	public void setNext(Node<E> newNext){
		next= newNext;
	}

}
