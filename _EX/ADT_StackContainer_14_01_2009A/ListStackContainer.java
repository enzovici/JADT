package ADT_StackContainer_14_01_2009A;

import position.*;
import stack.Stack;

public class ListStackContainer<E> implements StackContainer<E> {

	private PositionList<Stack<E>> lista;
	
	
	public ListStackContainer(){
		lista = new NodePositionList<Stack<E>>();
	}
	
	/** crea una nuova pila avente come elementi gli elementi della lista L e la inserisce nel contenitore 
	 */
	public Stack<E> insert(PositionList<E> L) {
	
		MyStack<E> pila = new MyStack<E>();
		
		for(E element : L){
			pila.push(element);
		}
		ordinaStack(pila);
		
		return pila;
	}

	/** aggiunge alla pila S l’elemento 'e' (si tralasci l’implementazione dell’eccezione relativa al caso in cui S 
	 *  non sia nel contenitore)
	 */
	public Stack<E> add(Stack<E> S, E elem) {
		
		MyStack<E> pila = (MyStack<E>) S;
		S.push(elem);
		
		return pila;
	}

	/** restituisce la collezione iterabile delle pile che si trovano nel contenitore
	 */
	public Iterable<Stack<E>> elements() {
		PositionList<Stack<E>> listaStack = new NodePositionList<Stack<E>>();
		for(Stack<E> p : lista)
			listaStack.addLast(p);
	
		return listaStack;
	}
	
	/** rimuove dal contenitore la pila avente il maggior numero di elementi
	 */
	public void remove() {
		MyStack<E> last = (MyStack<E>) lista.last().element();
		lista.remove(last.position());
			
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public int size() {
		return lista.size();
	}

	public void ordinaStack(Stack<E> pila){
		
		MyStack<E> pila1 = (MyStack<E>) pila;
		
		for(Position<Stack<E>> pg : lista.positions())
			if(pila1.size() <= pg.element().size() ){
				lista.addBefore(pg,pila1);
				pila1.setPosition(lista.prev(pg));
			return;
			}
		
		lista.addLast(pila1);
		pila1.setPosition(lista.last());
	}
	
}
