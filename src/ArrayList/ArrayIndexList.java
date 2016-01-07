package arrayList;


import iterator.IndexListIterator;

import java.util.Iterator;

import exception.IndexOutOfBoundsException;

public class ArrayIndexList<E> implements IndexList<E> {
	protected E[] array;
	protected int size=0;
	protected int capacity;
	protected static final int CAPACITY=1024;
	
	public ArrayIndexList(){
		this(CAPACITY);
	}
	
	public ArrayIndexList(int c){
		capacity=c;
		array = (E[]) new Object[capacity];
	}
	
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		E tmp=array[i];
		for(int j=i; j<size-1; j++)
			array[j]=array[j+1];
		array[size-1]=null;
		size--;
		if(size()<=capacity/4){
			capacity/=2;
			E[] A = (E[]) new Object[capacity];
			for(int j=0; j<size(); j++)
				A[j]=array[j];
			array=A;
		}
			
		return tmp;
	}

	/*public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i,size()+1);
		if(size==capacity){
			capacity*=2;
			E[] A = (E[]) new Object[capacity];
			for(int j=0; j<i; j++)
				A[j]=array[j];
			array=A;
		}
		for(int j=size; j>i; j--)
			array[j]=array[j-1];
		array[i]=e;	
		size++;
	}*/
	
	public void add(int i,E e) throws IndexOutOfBoundsException{
		checkIndex(i,size()+1);
		if(size()==capacity){
			capacity*=2;
			E[] nuovo= (E[]) new Object[capacity];
			for(int j=0;j<i;j++){
				nuovo[j]=array[j];
			}
			nuovo[i]=e;
			size++;
			for(int j=i+1; j<size();j++ ){
				nuovo[j]=array[j-1];
			}
			array=nuovo;
		}
		else{
			for(int j=size(); j>i; j--)
				array[j]= array[j-1];
			size++;
			array[i]=e;
		}
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		E tmp= array[i];
		array[i]=e;
		return tmp;
	}

	public E get(int i) throws IndexOutOfBoundsException{
		checkIndex(i,size());
		return array[i];
	}

	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public int size() {
		return size;
	}
	
	public void checkIndex(int r, int n) throws IndexOutOfBoundsException{
		if(r<0||r>=n)
			throw new IndexOutOfBoundsException("indice non disponibile");
	}
	
	public int capacity(){
		return capacity;
	}
	
	public String toString(){
		String s="[ ";
		if(!isEmpty()){
			for(int i=0;i<size()-1;i++)
				s+=array[i]+", ";
			s+=array[size()-1];
		}
		s+=" ]";
		return s;
	}
	
	
	//Metodo Clone
	public IndexList<E> clone(){
		ArrayIndexList<E> Temp = new ArrayIndexList<E>();
		for(int i = 0; i<size();i++)
			Temp.add(i, get(i));
		return Temp;
	}
	//Metodo Equals
	public boolean equals(IndexList<E> V){
		boolean result = true;
		int size = size();
		
		if(size != V.size())
			return false;
		
		if((get(0) == null) && (V.get(0) == null))
			return true;
		
		for(int i = 0; i<size();i++){
			if((get(i) != V.get(i)) && (result == true))
				result = false;
		}
		return result;
	}
	
	//Metodo InvertTo
	public void invertTo(int r){
		checkIndex(r, size());
		int rmezzo =(int) (r)/2;
		E temp=null;
		E prova = null;
		for(int i=0; i<=rmezzo; i++){
			temp = get(i);
			set(i, get(r-i));
			set(r-i, temp);
		}
	}



}
