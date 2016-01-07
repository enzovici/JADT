package position;


public class ArrayPosition<E> implements Position<E> {
	
	int index;
	E element;
	
	public ArrayPosition(int i, E e){
		index=i; 
		element= e;
	}
	
	public ArrayPosition(){}
	
	public E element() {
		return element;
	}
	
	public int getIndex(){
		return index;
	}
	
	public E setElement(E e){
		E tmp= element;
		element=e;
		return tmp;
	}
	
	public int setIndex(int i){
		int tmp= index;
		index=i;
		return tmp;
	}
	

}
