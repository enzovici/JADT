package sequence;

import iterator.*;

import java.util.Iterator;

import position.*;
import nodeList.NodePositionList;
import nodeList.PositionList;
import exception.BoundaryViolationException;
import exception.EmptyListException;
import exception.EmptySequenceException;
import exception.IndexOutOfBoundsException;
import exception.InvalidPositionException;
import arrayList.ArrayIndexList;

public class ArraySequence<E> extends ArrayIndexList<E> implements Sequence<E> {
	protected ArrayPosition<E> A[];
	protected int size=0;
	protected int capacity;
	protected static final int CAPACITY=1024;
	
	public ArraySequence(){
		this(CAPACITY);
	}
	
	public ArraySequence(int cap){
		A=(ArrayPosition<E>[]) new ArrayPosition[cap];
		capacity=cap;
	}
	public void add(int i, E e)throws IndexOutOfBoundsException{
		checkIndex(i,size()+1);
		if(size()==capacity){
			ArrayPosition<E>[]B=(ArrayPosition<E>[]) new ArrayPosition[capacity*2];
			capacity*=2;
			for(int j=0;j<size();j++)
				B[j]=A[j];
			A=B;
		}
		if(!isEmpty()){
			for(int j=size()-1;j>=i;j--){
				A[j+1]=A[j];
				A[j+1].setIndex(j+1);
			}
		}
		A[i]= new ArrayPosition<E>(i,e);
		size++;
	}
	
	
	
	public Position<E> addBefore(Position<E> p, E e)
			throws InvalidPositionException {
		int i= indexOf(p);
		add(i,e);
		return A[i];
	}

	
	public Position<E> addAfter(Position<E> p, E e)
			throws InvalidPositionException {
		int index=indexOf(p);
		add(index+1,e);
		return A[index+1];
	}

	public void addFirst(E e) {
		add(0,e);
	}

	public void addLast(E e) {
		add(size(),e);
	}

	public E remove(int i) throws InvalidPositionException {
		checkIndex(i,size());
		E elem = A[i].element();
		for(int j=i;j<size()-1;j++){
			A[j]=A[j+1];
			A[j].setIndex(j);
		}
		A[size()-1]=null;
		size--;
		if(size()<=capacity/4){
			capacity/=2;
			E[] A = (E[]) new Object[capacity];
			for(int j=0; j<size(); j++)
				A[j]=array[j];
			array=A;
		}
		return elem;
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		int index= indexOf(p);
		return remove(index);
	}
	
	public E removeFirst() throws EmptySequenceException {
		if(isEmpty()) throw new EmptySequenceException("sequence vuoto");
		return remove(0);
	}
	
	public E removeLast() throws EmptySequenceException {
		if(isEmpty()) throw new EmptySequenceException("sequence vuoto");
		return remove(size()-1);
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		ArrayPosition<E> v= checkPosition(p);
		return set(indexOf(v),e);
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		E toReturn= A[i].element();
		A[i].setElement(e);
		return toReturn;
	}
	
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i,size());
		E toReturn= A[i].element();
		return toReturn;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		return size;
	}

	public E getFirst() throws EmptySequenceException {
		if(isEmpty())throw new EmptySequenceException("sequence vuoto");
		return A[0].element();
	}

	public E getLast() throws EmptySequenceException {
		if(isEmpty())throw new EmptySequenceException("sequence vuoto");
		return A[size()-1].element();
	}

	public Position<E> first() throws EmptyListException {
		if(isEmpty())throw new EmptySequenceException("sequence vuoto");
		return A[0];
	}

	public Position<E> last() throws EmptyListException {
		if(isEmpty())throw new EmptySequenceException("sequence vuoto");
		return A[size()-1];
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException,
			BoundaryViolationException {
		checkPosition(p);
		if(p==first()) throw new BoundaryViolationException("impossibile retrocedere oltre l'inizio");
		int index=indexOf(p);
		return A[index-1];	}

	public Position<E> next(Position<E> p) throws InvalidPositionException,
			BoundaryViolationException {
		checkPosition(p);
		if(p==last()) throw new BoundaryViolationException("impossibile avanzare oltre la fine");
		int index=indexOf(p);
		return A[index+1];
	}

	public Iterable <Position <E>> positions(){
		PositionList<Position<E>> toReturn= new NodePositionList<Position<E>>();
		if(!isEmpty()){
			Position<E> current=first();
			for(int i=0; i<size()-1;i++){
				toReturn.addLast(current);
				current=next(current);
			}
			toReturn.addLast(last());
		}
		return toReturn;
	}

	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Position<E> atIndex(int index) throws BoundaryViolationException {
		checkIndex(index,size());
		return A[index];
	}

	@Override
	public int indexOf(Position<E> position) throws InvalidPositionException {
		ArrayPosition<E> v = checkPosition(position);
		return v.getIndex();
	}

	public void checkIndex(int r, int n) throws IndexOutOfBoundsException{
		if(r<0||r>=n)
			throw new IndexOutOfBoundsException("indice non disponibile");
	}
	
	private ArrayPosition<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p==null) throw new InvalidPositionException("posizione non valida");
		try{
			ArrayPosition<E> v = (ArrayPosition<E>) p;
			return v;
		}
		catch(ClassCastException err){
			throw new InvalidPositionException("posizione non valida");
		}
	}
	
	public String toString(){
		String s="(first)[ ";
		for(int i=0;i<size();i++){
			s+=A[i].element();
			if(i!=size()-1)
				s+=", ";
		}
		return s+=" ](last)";
	}
	
	public int capacity(){
		return capacity;
	}
}
