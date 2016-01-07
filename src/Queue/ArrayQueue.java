package queue;

import stack.ArrayStack;
import exception.EmptyQueueException;
import exception.NotEnoughElements;

public class ArrayQueue<E> implements Queue<E>{
	private int front=0;
	private int rear=0;
	private int capacity;
	private E S[];
	
	//capacità di default
	public static final int CAPACITY=1000;
	
	//costruttore di default
	public ArrayQueue(){
		this(CAPACITY);
	}
		
	//costruttore parametrico
	public ArrayQueue(int cap){
		capacity=cap;
		S=(E[]) new Object[capacity];
	}
	
	public void enqueue(E x) {
		if(size()==capacity-1){
			int f=front;
			int capacity2=capacity*2;
			E[] A=(E[]) new Object[capacity2];
			for(int i=0;i<size();i++){
				A[i]=S[f%(capacity)];
				f++;
			}
			rear=size();
			S=A;
			front=0;
			capacity=capacity2;
		}	
		S[rear]=x;
		rear=(rear+1)%(capacity);
	}
	
	public E dequeue() {
		if (isEmpty()) 
			throw new EmptyQueueException("coda vuota");
		E temp=S[front];
		S[front]=null;
		front=(front+1)%capacity;
		if(size()<=capacity/4){
			int f=front;
			int capacity2=capacity/2;
			E[] A=(E[]) new Object[capacity2];
			for(int i=0;i<size();i++){
				A[i]=S[f%(capacity)];
				f++;
			}
			rear=size();
			S=A;
			front=0;
			capacity=capacity2;
		}
		return temp;
	}
	
	public E front() {
		if(isEmpty()) throw new EmptyQueueException("coda vuota");
		return S[front];
	}
	
	public int size() {
		return (capacity+rear-front) % capacity;
	}
	
	public boolean isEmpty() {
		return (rear==front);
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public String toString() {
		int f=front;
		String s="(front) [";
		if(!isEmpty()){
			for(int i=0;i<size();i++){
				s+=S[f%capacity];
				if(i!=size()-1)
					s+=", ";
				f++;
			}
		}
		s+="] (rear)";
		return s;
		
	}
	
	public String toString2(){
		String s="[ ";
		for(int i=0;i<capacity;i++){
			s+=S[i];
			if(i!=capacity-1)
				s+=", ";
		}
		s+=" ]";
		return s;
	}
	
	
	//Metodo Clone
	public Queue<E> clone(){
		int size = size();
		E element;
		ArrayQueue<E> temp = new ArrayQueue<E>();
		for(int i = 0;i<size; i++){
			element = dequeue();
			temp.enqueue(element);
			enqueue(element);
		}
		return temp;
	}
	
	public boolean equal(Queue<E> Q){
		boolean result = true;
		int k = size();
		
		if(k != Q.size())
			return false;
		
		if((front() == null) && (Q.front() == null))
			return true;
		ArrayQueue<E> Temp1 = new ArrayQueue<E>();
		ArrayQueue<E> Temp2 = new ArrayQueue<E>();
		
		E elemento1 = null;
		E elemento2 = null;
		
		for(int i = 0; i < k; i++){
			Temp1.enqueue(dequeue());
			Temp2.enqueue(Q.dequeue());
		}
		
		for(int i = 0;i < k; i++){
			elemento1 = Temp1.dequeue();
			elemento2 = Temp2.dequeue();
			enqueue(elemento1);
			Q.enqueue(elemento2);
			
			if(elemento1 != elemento2)
				result = false;
		}	
		return result;
	}
	
	public E Last(){
		int size = size();
		while(size>1){
			enqueue(dequeue());
			size--;
		}
		enqueue(front());
		return dequeue();
	}
	
	public E extract(int k) throws NotEnoughElements{
		int size = size();
		E element = null;
		
		if(k>size()) 
			throw new NotEnoughElements("Nessun elemento");
		
		for(int i = 0; i<k;i++){
			element = dequeue();
			enqueue(element);
		}
		
		for(int i = 0; i<size-k;i++){
			enqueue(dequeue());
		}
		return element;
	}
	
	public void Reverse() {
		ArrayStack<E> P = new ArrayStack<E>();
		
		while (!isEmpty()) 
			P.push(dequeue());
		while (!P.isEmpty()) 
			enqueue(P.pop());
		}

}


