package ADT_StackContainer_14_01_2009A;

import position.NodePositionList;
import position.PositionList;
import stack.ArrayStack;
import stack.Stack;

public class ListStackContainerTester {
@SuppressWarnings("all")	
	public static void main(String args[]){
		
		ListStackContainer<Integer> lista = new ListStackContainer<Integer>();
		
		
		
		PositionList<Integer> l1 = new NodePositionList<Integer>();
		l1.addLast(1);
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(4);
		ArrayStack<Integer> pila1 = (ArrayStack<Integer>) lista.insert(l1);
		
		
		PositionList<Integer> l2 = new NodePositionList<Integer>();
		l2.addLast(1);
		l2.addLast(2);
		l2.addLast(3);
		l2.addLast(4);
		l2.addLast(5);
		l2.addLast(6);
		l2.addLast(7);
		l2.addLast(8);
		l2.addLast(9);
		l2.addLast(10);
		ArrayStack<Integer> pila2 = (ArrayStack<Integer>) lista.insert(l2);
		
		
		PositionList<Integer> l3 = new NodePositionList<Integer>();
		l3.addLast(12);
		l3.addLast(2);
		l3.addLast(3);
		l3.addLast(4);
		l3.addLast(5);
		l3.addLast(6);
		l3.addLast(7);
		ArrayStack<Integer> pila3 = (ArrayStack<Integer>) lista.insert(l3);
		
		
		for(Stack<Integer> pl : lista.elements()){
			
			ArrayStack<Integer> S = new ArrayStack<Integer>(1000);
			String s ="(";
			while(!pl.isEmpty())
				S.push(pl.pop());
			
			while(!S.isEmpty()){
				s+=S.top()+", ";
				pl.push(S.pop());
			}
			
			s= s.substring(0,s.length()-2);
			s+=" top)";
			System.out.println(s);
		}
		
		System.out.println("\nStack rimanenti nel contenitore dopo la rimozione dello stack pila2 che ha il" +
							" più alto numero di elementi: ");
		lista.remove();
	

		for(Stack<Integer> p : lista.elements()){
			
			ArrayStack<Integer> S = new ArrayStack<Integer>(1000);
			String s ="(";
			while(!p.isEmpty())
				S.push(p.pop());
			
			while(!S.isEmpty()){
				s+=S.top()+", ";
				p.push(S.pop());
			}
			
			s= s.substring(0,s.length()-2);
			s+=" top)";
			System.out.println(s);
		}
		
		System.out.println("\nStack rimanenti nel contenitore dopo la rimozione dello stack pila3 che ha il" +
		" più alto numero di elementi: ");
		
		lista.remove();


		for(Stack<Integer> pp : lista.elements()){

			ArrayStack<Integer> S = new ArrayStack<Integer>(1000);	
			String s ="(";
			
			while(!pp.isEmpty())
				S.push(pp.pop());

			while(!S.isEmpty()){
				s+=S.top()+", ";
				pp.push(S.pop());
			}

			s= s.substring(0,s.length()-2);
			s+=" top)";
			System.out.println(s);
		}
		
		System.out.println("\nIl contenitore è vuoto??? "+lista.isEmpty());
		System.out.println("\nQuanti elementi ci sono nel contenitore??? "+lista.size());
		
	}
}