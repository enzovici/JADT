package stack;

import exception.EmptyStackException;

public class ArrayStack <E> implements Stack<E>{
	private int capacity;
	private E S[];
	private int top=-1;
	
	//capacità di default
	public static final int CAPACITY=1000;
	
	//costruttore di default
	public ArrayStack(){
		this(CAPACITY);
	}
	
	//costruttore parametrico
	public ArrayStack(int cap){
		capacity=cap;
		S=(E[]) new Object[capacity];
	}
	
	//push dinamico
	public void push(E x){
		if(capacity==size()){
			E[] newArray= (E[])new Object[capacity*2];
			for(int i=0;i<capacity;i++)
				newArray[i]=S[i];
			S=newArray;
			capacity*=2;
		}
		top=top+1;
		S[top]=x;
	}
	
	public E top() throws EmptyStackException{
		
		if(isEmpty())
			throw new EmptyStackException("stack vuoto");
		return S[top];
	}
	
	public E pop() throws EmptyStackException{
		E element;
		if(isEmpty())
			throw new EmptyStackException("stack vuoto");
		element=S[top];
		S[top--]=null;	
		if(size()<=capacity/4){
			capacity/=2;
			E[] A = (E[]) new Object[capacity];
			for(int j=0; j<size(); j++)
				A[j]=S[j];
			S=A;
		}
		return element;
	}
	
	public int size(){
		return top+1;
	}
	
	public boolean isEmpty(){
		return(size()==0);
	}
	
	public int getCapacity(){
		return capacity;
	}

	public String toString() {
		String s="(bottom) [";
		if(!isEmpty()){
			for(int i=0;i<size();i++){
				s+=S[i];
				if(i!=size()-1)
					s+=", ";
			}
		}
		s+="] (top)";
		return s;
	}
	

	//Metodo Clone()
	public Stack<E> clone(){
		ArrayStack<E> Temp = new ArrayStack<E>();
		ArrayStack<E> copia = new ArrayStack<E>();
		int k = size();
		E element;
		for(int i = 0; i<k;i++){
			Temp.push(pop());
		}
		for(int i = 0; i<k;i++){
			element = Temp.pop();
			push(element);
			copia.push(element);
		}
		return copia;
	}
	//Metodo Equals()
	public boolean equals(Stack<E> Stack){
		boolean result = true;
		int k = size();
		
		//Se le dimensioni sono diverse restituisce false
		if(k != Stack.size())
			return false;
		
		//Se sono entrambi vuoti restituisce true
		if((top() == null) && (Stack.top() == null))
			return true;
		
		ArrayStack<E> Temp1 = new ArrayStack<E>();
		ArrayStack<E> Temp2 = new ArrayStack<E>();
		E elemento1 = null;
		E elemento2 = null;
		for(int i=0; i<k; i++){
			Temp1.push(pop());
			Temp2.push(Stack.pop());
		}
		for(int i=0; i<k; i++){
			elemento1 = Temp1.pop();
			elemento2 = Temp2.pop();
			push(elemento1);
			Stack.push(elemento2);
			if((elemento1 != elemento2) && (result == true))
				result = false;
		}
		return result;
	}
	
	public boolean Double(){
		boolean result = true;
		int k;
		ArrayStack<E> Clone = new ArrayStack<E>();
		Clone = (ArrayStack<E>) clone();
		ArrayStack<E> Temp = new ArrayStack<E>();
		ArrayStack<E> Temp1 = new ArrayStack<E>();
		if(size()%2 == 1){
			result = false;
		}
		else{
			k = size()/2;
			for(int i = 0; i<k;i++)
				Temp.push(Clone.pop());
			
			for(int i = 0; i<k;i++)
				Temp1.push(Temp.pop());
			
			if(Temp1.equals(Clone)){
				return result;
				}
				else {
				 result = false;	
				}
			}
		return result;
	}
}
