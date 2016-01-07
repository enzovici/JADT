package _ex;

import java.util.Iterator;

import position.Position;
import sequence.NodeSequence;
import sequence.Sequence;

public class TestSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sequence<Integer> S = new NodeSequence<Integer>();
		
		//popolo S
		for(int i = 0 ; i < 20; i++){
			S.add(i, i);
		}
		
		
		System.out.println("inizialmente gli elementi della sequenza hanno: <");
		for(Integer el : S){
			System.out.print(el + " ");
		}
		System.out.println(">");
		
		
	
	
	}

	public static<E> void remove(Sequence<E>  S, E x){
		if(S.isEmpty())return;
		for(Position<E>  p : S.positions()){
			if(p.element().equals(x)){
			S.remove(p);
			return;
			}
		}
		return;
	}

	
	public static <E> void remove1(Sequence<E> S, E x){
		if(S.isEmpty())return;
		
		Iterable <Position<E>> L = S.positions();
		Iterator<Position<E>> it = L.iterator();
		while(it.hasNext()){
			Position<E> p = it.next();
			if(p.element().equals(x)){
				S.remove(p);
				return;
			}
		}
		
	}
	
	public static<E> void reverse(Sequence<E> S){
		if(S.size() <= 1)return;
		
		E tmp = S.remove(0);
		
		reverse(S);
		
		S.addLast(tmp);
		
	}
	
	public static<E> Sequence<E> reverse1(Sequence<E> S){
		Sequence <E> toReturn = new NodeSequence<E>();
		reverse1(S, toReturn);
		return toReturn;
	}
	public static<E> void reverse1(Sequence<E> S, Sequence<E> out){
			if(S.size() == 0)return;
			
			E tmp = S.remove(0);
			reverse1(S,out);
			out.addLast(tmp);
		
	}
	
}
